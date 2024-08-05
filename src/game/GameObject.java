package game;

/**
 * <b>GameObject</b>
 * <p>All game object must inherit this class</p> 
 *
 * @version 1.0
 * @author Johnrey Bacal [jbacal@tspi.com.ph]
 */
public abstract class GameObject {
	
	/**
	 * <b>name</b><p>the name of the game object</b>
	 */
	private String name;
	
	public GameObject(){
		this.name = "undefined";
	}
	
	/**
	 * <b>GameObject</b><p>sets the name of the game object</p>
	 * @param name
	 */
	public GameObject(String name){
		this.name = name;
	}
	
	/**
	 * <b>getName</b>
	 * @return the name of the game object
	 */
	public String getName(){
		return this.name;
	}
	
}
