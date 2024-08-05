package items;

/**
 * <b>Equipment</b>
 * <p>is of type <b>GameItem</b>, can be inherited by <b>Armor</b> and 
 * <b>Weapon</b></p> 
 *
 * @version 1.0
 * @author Johnrey Bacal [jbacal@tspi.com.ph]
 */
public abstract class Equipment extends GameItem{

	
	private int weight;
	
	public Equipment(String name){
		super(name);
	}

	/**
	 * <b>getWeight</b>
	 * @return weight
	 */
	public int getWeight() {
		return this.weight;
	}

	/**
	 * <b>setWeight</b>
	 * @param weight
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
