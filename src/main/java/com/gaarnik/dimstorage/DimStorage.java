package com.gaarnik.dimstorage;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;

import com.gaarnik.dimstorage.storage.DimStorageManager;
import com.gaarnik.dimstorage.storage.chest.DimChestPlugin;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = DimStorage.MODID, version = DimStorage.VERSION, acceptedMinecraftVersions=DimStorage.MC_VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = true, 
channels={DimStorageNetwork.CHANNEL_DIMCHEST}, packetHandler=DimStorageNetwork.DimStoragePacketHandler.class)
public class DimStorage {
	// ****************************************************************
	public static final String MODID = "dimstorage";
	public static final String VERSION = "1.0";
	public static final String MC_VERSION = "1.6.4";

	// ****************************************************************
	@Instance
	public static DimStorage instance = new DimStorage();

	@SidedProxy(clientSide="com.gaarnik.dimstorage.client.ClientProxy", serverSide="com.gaarnik.dimstorage.server.ServerProxy")
	public static CommonProxy proxy;

	public static Configuration config;

	public static CreativeTabs tabDimStorage = new CreativeTabs("dimStorage") {
		@SideOnly(Side.CLIENT)
		@Override
		public ItemStack getIconItemStack() {
			return new ItemStack(DimStorage.dimChest, 1, 0);
		}
	};

	// block
	public static Block dimChest;

	// item
	public static Item dimCore;

	// ****************************************************************
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();

		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		DimStorageManager.registerPlugin(new DimChestPlugin());

		proxy.init(event);
	}
	
	@EventHandler
	public void postload(FMLPostInitializationEvent event) {
		config.save();
	}
	
	// ****************************************************************

	// ****************************************************************

}

