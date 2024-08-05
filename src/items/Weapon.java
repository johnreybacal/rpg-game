package items;

/**
 * <b>Weapon</b>
 * <p>is of type <b>Equipment</b>, 
 * this class contains attributes of a weapon</p> 
 *
 * @version 1.0
 * @author Johnrey Bacal [jbacal@tspi.com.ph]
 */
public class Weapon extends Equipment{

	/**
	 * <b>damage</b><p>the value to decrease to the target of type 
	 * <b>Creature</b> instance variable <b>hp</b>
	 */
	private int damage;
	
	/**
	 * <b>criticalChance</b><p>the chance of amplifying damage, 
	 * on a scale of 100</p>
	 */
	private int criticalChance;
	
	/**
	 * <b>counterChance</b><p>the chance of retaliation, on a scale of 100</p>
	 */
	private int counterChance;
	
	/**
	 * <b>stunChance</b><p>the chance of disabling the target making them lose 
	 * their turn, on a scale of 100</p>
	 */
	private int stunChance;
	
	public Weapon(String name){
		super(name);
	}
	
	/**
	 * <b>getName</b><p>overrides the getName() of the <b>GameObject</b> 
	 * and concatenating "[Weapon]"
	 * @return name
	 */
	public String getName(){
		return "[Weapon]" + super.getName();
	}
	
	/**
	 * <b>setDamage</b>
	 * @param damage
	 */
	public void setDamage(int damage){
		this.damage = damage;
	}
	
	/**
	 * <b>getDamage</b>
	 * @return damage
	 */
	public int getDamage(){
		return this.damage;
	}

	/**
	 * <b>setCriticalChance</b>
	 * @param criticalChance
	 */
	public void setCriticalChance(int criticalChance) {
		this.criticalChance = criticalChance;
	}

	/**
	 * <b>getCriticalChance</b>
	 * @return criticalChance
	 */
	public int getCriticalChance() {
		return this.criticalChance;
	}

	/**
	 * <b>setCounterChance</b>
	 * @param counterChance
	 */
	public void setCounterChance(int counterChance) {
		this.counterChance = counterChance;
	}
	
	/**
	 * <b>getCounterChance</b>
	 * @return counterChance
	 */
	public int getCounterChance() {
		return this.counterChance;
	}

	/**
	 * <b>setStunChance</b>
	 * @param stunChance
	 */
	public void setStunChance(int stunChance) {
		this.stunChance = stunChance;
	}

	/**
	 * <b>getStunChance</b>
	 * @return stunChance
	 */
	public int getStunChance() {
		return this.stunChance;
	}
	
}
