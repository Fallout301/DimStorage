Version 1.4
===========

- evolutions:
- [X] le craft des DimWall donne 2 exemplaires de l'item par craft (reduit un peu le cout)
- [ ] faire en sorte que le parametre locked soit un parametre du storage et non de la TE.
- [ ] retirer l'overlay d'information => faire un shift+clic droit affiche une fenetre de config
- [ ] PortableDimChest
	- [ ] changer le nom dans le code (anciennement DimChestController)
	- [X] creer l'item.
	- [x] fonctionnement de base
	- [ ] linker un DimChest avec shift+clic droit
	- [ ] ne pas ouvrir la fenetre si le DimChest est locked
	- [ ] texture
- [ ] DimTank:
	- [ ] Terminer l'implementation de la tileentity TEDimTank
	- [ ] fonctionnement general
	- [ ] creer le model qui affichera le contenu du tank (avec une jauge pour voir le liquide)
	- [ ] GUI pour afficher le detail du Tank (liquide + info overlay)

- bugs:
- [ ] PRIORITAIRE: lance une partie, ouvre un coffre, change la frequence: si un stack est identique au precedent stack sur le meme slot alors rien ne s'affiche
- [ ] PRIORITAIRE: quitter et relancer rapidement ne sauvegarde pas les changements sur le DimChest
- [ ] il semble y avoir une baisse de FPS en ouvrant le coffre, peut etre du a l'animation d'ouverture du coffre
- [ ] En jouant sur un serveur, si on met a jour le DimChest (freq ou owner) via un ordinateur, l'inventaire est bien mis a jour
mais l'interface continue d'afficher les anciennes infos.
- [ ] Toujours sur un serveur, a la connexion du client les coffres sont tout noir (bug de lumiere je suppose).
- [X] pixel blanc sur la texture du bouton rouge

Version 1.5
===========

- evolutions:
- [ ] RF power requirement (avec option dans la config)
- [ ] NEI plugin/InventoryTweaks integration
- [ ] integration de l'API ComputerCraft ( getOwner, getFreq, isLocked, setOwner, setPublic, setFreq ) + getItemInSlot (savoir quel item est dans quel slot)
