package items;

/**
 * <b>Inventory</b>
 * <p>the storage for <b>GameItem</b> of <b>Creature</b></p> 
 * TODO make more use of this class
 * TODO make loots
 * @version 1.0
 * @author Johnrey Bacal [jbacal@tspi.com.ph]
 */
import java.util.ArrayList;

public class Inventory {
	
	/**
	 * <b>inventory</b><p>list of items of the creature</p>
	 */
	private ArrayList<GameItem> inventory;
	
	public Inventory(){	
		inventory = new ArrayList<GameItem>();		
	}
	
	/**
	 * <b>add</b><p>adds one <b>GameItem</b> to inventory</b>
	 * @param item
	 */
	public void add(GameItem item){
		this.inventory.add(item);
	}

	/**
	 * <b>add</b><p>adds an <b>ArrayList</b> of <b>GameItem</b> to inventory</b>
	 * @param items
	 */
	public void add(ArrayList<GameItem> items){
		this.inventory.addAll(items);
	}
	
	/**
	 * <b>getAll</b>
	 * @return inventory
	 */
	public ArrayList<GameItem> getAll(){
		return this.inventory;
	}
	
	/**
	 * <b>hasItem</b>
	 * @param item
	 * @return boolean <p>if the <b>GameItem</b> exist inside the 
	 * <b>inventory</b></p>
	 */
	public boolean hasItem(GameItem item){
		return this.inventory.contains(item);
	}
	
}
