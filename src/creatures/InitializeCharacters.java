package creatures;

import static items.InitializeItems.*;

public final class InitializeCharacters {

	public static Player john = new Player("John Smith", new Human());
	public static Player jin = new Player("Jin Sushi", new Human());
	public static Player jakro = new Player("Jak'ro", new Goblin());
	public static Player marcus = new Player("Marcus Sin", new Human());
	public static Player zakKaa = new Player("Zak Kaa", new Orc());
	public static Player tai = new Player("Tai Ling", new Human());

	public InitializeCharacters(){
		//heavy soldier
		john.setDialogue("Hello there");
		john.inventory.add(mjolnir);
		john.inventory.add(plateMail);
		john.equip(mjolnir);
		john.equip(plateMail);
		john.setHP(80);

		//swordsman
		jin.setDialogue("How dare you stand against the dynasty?");
		jin.inventory.add(sword);
		jin.inventory.add(leatherVest);
		jin.equip(sword);
		jin.equip(leatherVest);
		jin.setHP(85);

		//mid range - javelin
		jakro.setDialogue("I am enjoying this");
		jakro.inventory.add(javelin);
		jakro.inventory.add(robe);
		jakro.equip(javelin);
		jakro.equip(robe);
		jakro.setHP(75);

		//human assassin
		marcus.setDialogue("I am one with the shadow");
		marcus.inventory.add(dagger);
		marcus.inventory.add(leatherHood);
		marcus.equip(dagger);
		marcus.equip(leatherHood);
		marcus.setHP(80);

		//orc chieftain
		zakKaa.setDialogue("This land is my clan's");
		zakKaa.inventory.add(mace);
		zakKaa.inventory.add(chainMail);
		zakKaa.equip(mace);
		zakKaa.equip(chainMail);
		zakKaa.setHP(125);

		//fist fighter - retaliation
		tai.setDialogue("You cannot take away my honor");
		tai.inventory.add(knuckles);
		tai.inventory.add(leatherVest);
		tai.equip(knuckles);
		tai.equip(leatherVest);
		tai.setHP(95);
	}

}
