package items;

/**
 * <b>Armor</b>
 * <p>is of type <b>Equipment</b>, 
 * this class contains attributes of an armor</p> 
 *
 * @version 1.0
 * @author Johnrey Bacal [jbacal@tspi.com.ph]
 */
public class Armor extends Equipment {

	/**
	 * <b>defense</b><p>damage reduction from attacks</b>
	 */
	private int defense;
	
	/**
	 * <b>dodgeChance</b><p>the chance of dodge, on a scale of 100</p>
	 */
	private int dodgeChance;
	
	public Armor(String name){
		super(name);
	}

	/**
	 * <b>getName</b><p>overrides the getName() of the <b>GameObject</b> 
	 * and concatenating "[Armor]"
	 * @return name
	 */
	public String getName(){
		return "[Armor]" + super.getName();
	}
	
	/**
	 * <b>setDefense</b>
	 * @param defense
	 */
	public void setDefense(int defense){
		this.defense = defense;
	}
	
	/**
	 * <b>getDefense</b>
	 * @return defense
	 */
	public int getDefense(){
		return this.defense;
	}
	
	/**
	 * <b>setDodgeChance</b>
	 * @param dodgeChance
	 */
	public void setDodgeChance(int dodgeChance) {
		this.dodgeChance = dodgeChance;
	}
	
	/**
	 * <b>getDodgeChance</b>
	 * @return dodgeChance
	 */
	public int getDodgeChance() {
		return this.dodgeChance;
	}
}
