package items;

public final class InitializeItems {

	public static Weapon weaponNone = new Weapon("None");
	public static Weapon dagger = new Weapon("Dagger");
	public static Weapon sword = new Weapon("Sword");
	public static Weapon javelin = new Weapon("Javelin");
	public static Weapon mjolnir = new Weapon("Mjolnir");
	public static Weapon mace = new Weapon("Mace");
	public static Weapon knuckles = new Weapon("Knuckles");
	public static Weapon divineRapier = new Weapon("Divine Rapier");

	public static Armor armorNone = new Armor("None");
	public static Armor robe = new Armor("Robe");
	public static Armor leatherHood = new Armor("Leather Hood");
	public static Armor leatherVest = new Armor("Leather Vest");
	public static Armor chainMail = new Armor("Chain Mail");
	public static Armor plateMail = new Armor("Plate Mail");
	public static Armor holyArmor = new Armor("Holy Armor");

	public InitializeItems(){
		weapons();
		armors();
	}

	public void weapons() {
		weaponNone.setDamage(1);
		weaponNone.setCriticalChance(75);
		weaponNone.setCounterChance(90);
		weaponNone.setWeight(2);
		weaponNone.setStunChance(10);

		dagger.setDamage(20);
		dagger.setCriticalChance(60);
		dagger.setCounterChance(75);
		dagger.setPrice(100);
		dagger.setWeight(10);
		dagger.setStunChance(5);

		sword.setDamage(30);
		sword.setCriticalChance(15);
		sword.setCounterChance(20);
		sword.setPrice(300);
		sword.setWeight(15);
		sword.setStunChance(15);

		javelin.setDamage(26);
		javelin.setCriticalChance(35);
		javelin.setCounterChance(10);
		javelin.setPrice(250);
		javelin.setWeight(25);
		javelin.setStunChance(20);

		mjolnir.setDamage(35);
		mjolnir.setCriticalChance(3);
		mjolnir.setCounterChance(2);
		mjolnir.setPrice(250);
		mjolnir.setWeight(35);
		mjolnir.setStunChance(45);

		mace.setDamage(24);
		mace.setCriticalChance(20);
		mace.setCounterChance(20);
		mace.setPrice(250);
		mace.setWeight(13);
		mace.setStunChance(40);

		knuckles.setDamage(19);
		knuckles.setCriticalChance(85);
		knuckles.setCounterChance(89);
		knuckles.setPrice(250);
		knuckles.setWeight(6);
		knuckles.setStunChance(38);

		divineRapier.setDamage(53);
		divineRapier.setCriticalChance(49);
		divineRapier.setCounterChance(29);
		divineRapier.setPrice(250);
		divineRapier.setWeight(25);
		divineRapier.setStunChance(20);

	}

	public void armors(){
		armorNone.setDefense(1);
		armorNone.setDodgeChance(75);
		armorNone.setWeight(2);

		robe.setDefense(10);
		robe.setDodgeChance(50);
		robe.setPrice(75);
		robe.setWeight(10);

		leatherHood.setDefense(12);
		leatherHood.setDodgeChance(37);
		leatherHood.setPrice(125);
		leatherHood.setWeight(12);

		leatherVest.setDefense(13);
		leatherVest.setDodgeChance(32);
		leatherVest.setPrice(125);
		leatherVest.setWeight(14);

		chainMail.setDefense(16);
		chainMail.setDodgeChance(15);
		chainMail.setPrice(200);
		chainMail.setWeight(20);

		plateMail.setDefense(18);
		plateMail.setDodgeChance(10);
		plateMail.setPrice(200);
		plateMail.setWeight(23);

		holyArmor.setDefense(33);
		holyArmor.setDodgeChance(28);
		holyArmor.setPrice(200);
		holyArmor.setWeight(21);
	}
}
