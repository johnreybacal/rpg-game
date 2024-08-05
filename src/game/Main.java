package game;

import java.util.ArrayList;
import creatures.*;
import items.InitializeItems;
import creatures.InitializeCharacters;
import static creatures.InitializeCharacters.*;
import static items.InitializeItems.*;

public class Main {

	public static void main(String[] args){

		new InitializeItems();
		new InitializeCharacters();
		ArrayList<Fighter> fighters = new ArrayList<Fighter>();
		Enemy diety = new Enemy("Diety", new Human());

		diety.setDialogue("I am absolute");
		diety.inventory.add(divineRapier);
		diety.inventory.add(holyArmor);
		diety.equip(divineRapier);
		diety.equip(holyArmor);
		diety.setHP(750);

		fighters.add(diety);
		fighters.add(john);
		fighters.add(jin);
		fighters.add(jakro);
		fighters.add(marcus);
		fighters.add(zakKaa);
		fighters.add(tai);
		BattleSimulation bt = new BattleSimulation(fighters, false);
		bt.simulateBattle();

	}
}
