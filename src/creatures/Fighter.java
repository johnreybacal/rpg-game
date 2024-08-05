package creatures;

import items.*;
import static items.InitializeItems.weaponNone;
import static items.InitializeItems.armorNone;

import java.util.ArrayList;
import java.util.Random;

/**
 * <b>Fighter</b>
 * <p><b>Creature</b> who can enter <b>BattleSimulation</b></p>
 * @version 1.0
 * @author Johnrey Bacal [jbacal@tspi.com.ph]
 */
public abstract class Fighter extends Creature {

	/**<b>creature</b><p>determines the race</p>*/
	protected Creature creature;

	/**<b>weapon</b><p><b>Weapon</b> equipped</p>*/
	protected Weapon weapon;

	/**<b>armor</b><p><b>Armor</b> equipped</p>*/
	protected Armor armor;

	/**<b>speed</b>
	 * <p>determines how fast the <b>Fighter</b> can take their turn</p>
	 */
	private int speed = 100;

	/**
	 * <b>moveIndex</b><p>used in <b>BattleSimulation</b> to determine if
	 * its the <b>Fighter</b> turn</p>
	 */
	public int moveIndex;

	Fighter(String name){
		super(name);
		this.weapon = weaponNone;
		this.armor = armorNone;
	}

	Fighter(String name, Creature creature){
		super(name);
		this.creature = creature;
		this.weapon = weaponNone;
		this.armor = armorNone;
	}

	/**
	 * <b>equip</b><p>adds <b>Equipment</b> to this <b>Fighter</b></p>
	 * @param equipment
	 */
	public void equip(Equipment equipment){
		if(this.inventory.hasItem(equipment)){
			if(equipment instanceof Weapon){
				this.reduceSpeed(equipment, this.weapon);
				this.weapon = (Weapon)equipment;
			}
			if(equipment instanceof Armor){
				this.reduceSpeed(equipment, this.armor);
				this.armor = (Armor)equipment;
			}
			System.out.println(this.getName() + " has equipped "
					+ equipment.getName());
		}
		else{
			System.out.println(this.getName() + " doesn't have a "
					+ equipment.getName() + " in their inventory");
		}
	}

	public String getRace() {
		return this.creature.getRace();
	}

	/**
	 * <b>attack</b>
	 * @param creature <p>the <b>Creature</b> to attack</b>
	 */
	public void attack(Creature creature){
		this.setCurrentState(State.ATTACKING);
		if(creature.isAlive()){
			
			Fighter target = (Fighter)creature;
			Random random = new Random();
			int baseDamage = this.weapon.getDamage();
			int criticalChance = this.weapon.getCriticalChance();
			int stunChance = this.weapon.getStunChance();
			int dodgeChance = target.armor.getDodgeChance();
			int baseDefense = target.armor.getDefense();
			int counterChance = target.weapon.getCounterChance();
			int deathBlowChance = (random.nextInt((100 - criticalChance)) + criticalChance);
			
			switch(target.getCurrentState()){
			case ATTACKING: //has less chance of dodging
				stunChance *= 1.25;
				criticalChance *= 2;
				dodgeChance /= 2;
				if(target.isAlive())
					target.setCurrentState(State.IDLE);
				break;
			case DEFENDING: //has more chance of dodging and counter attack
				dodgeChance *= 2;
				counterChance *= 1.25;
				if(target.isAlive())
					target.setCurrentState(State.IDLE);
				break;
			case STUNNED: //dodge and counter depends on chance
				baseDamage *= 1.25;
				stunChance *= 1.25;
				criticalChance *= 1.5;
				dodgeChance = random.nextInt(dodgeChance) + 1;
				counterChance = random.nextInt(counterChance) + 1;
				if(target.isAlive()){
					System.out.println(target.getName() + " has regained "
							+ "conciousness as");
					target.setCurrentState(State.IDLE);
				}
				break;
			default: break;
			}

			System.out.println(this.getName() + " attacked " + target.getName()
					+ " with a " + this.weapon.getName());

			//dodge
			if(dodgeChance >= random.nextInt(100) + 1){
				//attack dodged
				System.out.println("\tBut " + target.getName() + " has dodged");
				counterChance += (counterChance * 0.5);
			}
			else{
				//stun
				if(stunChance >= random.nextInt(100) + 1){
					System.out.println("\t" + target.getName() + " is stunned");
					target.setCurrentState(State.STUNNED);
					baseDefense *= 0.50; //lessen defense
				}
				//critical
				if(criticalChance >= random.nextInt(100) + 1){
					if(deathBlowChance >= random.nextInt(500)){
						System.out.println("\tA DEATH BLOW!!!");
						baseDamage *= 10;
					}
					else if(criticalChance >= random.nextInt(150) + 1){
						System.out.println("\tA CRITICAL HIT!!!");
						baseDamage *= 2.5;
					}
					else{
						System.out.println("\tA critical hit!");
						baseDamage *= 1.5;
					}
				}
				
				//decrease damage with armor
				baseDamage -= baseDefense;
				if(baseDamage < 1){
					System.out.println("\tBut it couldn't get through "
							+ target.getName() + "'s "+ target.armor.getName());
					if(baseDefense >= random.nextInt(100) + 1){
						//return damage
						System.out.println("\t" + target.getName() + "'s "+ target.armor.getName()
								+ " reflected " + this.getName() + "'s attack");
						this.decreaseHP((baseDamage * -1) + 5);
					}
					baseDamage = 1;
				}
				target.decreaseHP(baseDamage);
			}
			if(target.isAlive()){
				//if the target is still alive
				if(this.isAlive()){
					//if the attacker is still alive
					if(!target.isStunned()){
						//target will counter attack
						if(counterChance >= random.nextInt(100) + 1){
							System.out.println(target.getName() + " performed a "
									+ "counter attack");
							target.attack(this);
						}
					}
					else{
						//if the target is stunned after the attack, there is a
						//chance to take advantage of the moment and attack again
						if(stunChance >= random.nextInt(100) + 1){
							System.out.println(this.getName() + " realized that " +
									target.getName() + "'s guard is down");
							this.attack(target);
						}
					}
				}
				else{ //killed by damage reflect
					System.out.println(this.getName() + " was killed by his own attack");
					target.talk();
				}
			}
			else{ //kill
				System.out.println(target.getName() + " was killed by "
						+ this.getName());
				this.talk();
			}
		}
	}

	/**
	 * <b>defend</b>
	 * TODO make this fighters next turn earlier
	 */
	public void defend(){
		this.setCurrentState(State.DEFENDING);
		this.moveIndex += 5;
		System.out.println(this.getName() + " turns to a defensive form");
	}

	/**
	 * <b>decide</b>
	 * @param fighters <p>to choose a target</p>
	 * @param isFreeForAll
	 * TODO add personality to fighters if they are more likely to attack
	 */
	public void decide(ArrayList<Fighter> fighters, boolean isFreeForAll){
		System.out.println("\n>>>>" + this.getName() + "'s turn");
		if(this.isStunned()){//lose a turn
			System.out.println(this.getName() + " is unable to move");
			this.moveIndex -= 100 - this.getSpeed();
			if(this.moveIndex < 0){
				this.moveIndex = 100 + this.moveIndex;
			}
			this.setCurrentState(State.IDLE);
		}
		else{
			this.talk();
			Random random = new Random();
			//70% attack; 30% defend
			int decision = (random.nextInt(10) < 7) ? 0 : 1;

			switch(decision){
			case 0://attack
				Fighter target = fighters.get(
						this.findTarget(fighters, isFreeForAll));
				this.attack(target);
				break;
			case 1://defend
				this.defend();
				break;
			default:
				this.talk();
				break;
			}
		}
	}

	/**
	 * <b>findTarget</b>
	 * @param fighters
	 * @param isFreeForAll
	 * @return int <p>index of target in <i>fighters</i>
	 */
	public int findTarget(ArrayList<Fighter> fighters, boolean isFreeForAll){
		Random random = new Random();
		int currentFighter = fighters.indexOf(this);
		int targetIndex = currentFighter;
		do{
			targetIndex = random.nextInt(fighters.size());
			if(targetIndex != currentFighter){
				if(!isFreeForAll){
					if(this instanceof Enemy &&
							!(fighters.get(targetIndex) instanceof Enemy)){
						break;
					}
					if(this instanceof Player &&
							!(fighters.get(targetIndex) instanceof Player)){
						break;
					}
				}
				else{
					break;
				}
			}
		}while(true);
		return targetIndex;
	}

	/**
	 * <b>getSpeed</b>
	 * @return speed
	 */
	public int getSpeed() {
		return this.speed;
	}

	/**
	 * <b>reduceSpeed</b><p>reduces speed of <b>Fighter</b> based on
	 * <b>weight</b> of <b>Equipment</b></p>
	 * @param current <p>newly equipped <b>Equipment</b></p>
	 * @param prev <p>currently equipped <b>Equipment</b></p>
	 */
	public void reduceSpeed(Equipment current, Equipment prev) {
		this.speed += prev.getWeight();
		this.speed -= current.getWeight();
	}

}
