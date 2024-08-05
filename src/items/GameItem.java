package items;

import game.GameObject;

/**
 * <b>GameItem</b>
 * <p><b>GameObject</b> with use for <b>Creature</b></p> 
 *
 * @version 1.0
 * @author Johnrey Bacal [jbacal@tspi.com.ph]
 */
public abstract class GameItem extends GameObject{

	/**
	 * <b>price</b><p>the cost of an item</p>
	 * TODO make a Store class
	 */
	private int price;
	/**
	 * <b>quantity</b>
	 */
	private int quantity = 1;
	
	public GameItem(String name){
		super(name);
	}
	
	/**
	 * <b>setPrice</b>
	 * @param price
	 */
	public void setPrice(int price){
		this.price = price;
	}
	
	/**
	 * <b>getPrice</b>
	 * @return price
	 */
	public int getPrice(){
		return this.price;
	}

	/**
	 * <b>setQuantity</b>
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * <b>getQuantity</b>
	 * @return quantity
	 */
	public int getQuantity() {
		return this.quantity;
	}
	
}
