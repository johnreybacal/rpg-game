package creatures;

import items.GameItem;
import items.Inventory;
import game.GameObject;

/**
 * <b>Creature</b>
 * <p><b>GameObject</b> with life</p>
 * @version 1.0
 * @author Johnrey Bacal [jbacal@tspi.com.ph]
 */
public abstract class Creature extends GameObject
		implements Speakable, Distinguishable{

	/**
	 * <b>hp</b><p>health points of the <b>Creature</b></p>
	 */
	private int hp;

	/**
	 * <b>dialogue</b><p>the punch line of the Creature</p>
	 */
	private String dialogue;

	/**
	 * <b>State</b><p>enumeration of all the states of the <b>Creature</b></p>
	 */
	protected static enum State {IDLE, ATTACKING, DEFENDING, STUNNED, DEAD};

	/**
	 * <b>currentState</b><p>the current state of the <b>Creature</b></p>
	 */
	private State currentState;

	/**
	 * <b>inventory</b><p>the <b>Inventory</b> of the <b>Creature</b></p>
	 */
	public Inventory inventory;

	Creature(String name){
		super(name);
		this.inventory = new Inventory();
		this.setCurrentState(State.IDLE);
	}

	Creature() {
		this.inventory = new Inventory();
		this.setCurrentState(State.IDLE);
	}

	/**
	 * <b>getName</b><p>overrides the getName() of the <b>GameObject</b>
	 * and concatenating the race of the <b>Creature</b>
	 * @return name
	 */
	public String getName(){
		return "[" + this.getRace() + "]" + super.getName();
	}

	/**
	 * <b>setHP</b>
	 * @param hp
	 */
	public void setHP(int hp){
		this.hp = hp;
	}

	/**
	 * <b>isAlive</b>
	 * @return boolean <p>if the <b>Creature</b> is still alive</p?>
	 */
	public boolean isAlive(){
		return this.getCurrentState() != State.DEAD;
	}

	/**
	 * <b>isStunned</b>
	 * @return boolean <p>if the <b>Creature</b> is stunned</p?>
	 */
	public boolean isStunned(){
		return this.getCurrentState() == State.STUNNED;
	}

	/**
	 * <b>getHP</b>
	 * @return hp
	 */
	public int getHP(){
		return this.hp;
	}

	/**
	 * <b>decreaseHP</b>
	 * @param value <p>value to deduct to the <b>hp</b> of the
	 * <b>Creature</b></p>
	 */
	public void decreaseHP(int value){
		System.out.println(this.getName() + "'s hp was deducted by " + value);
		this.hp -= value;
		if(this.hp <= 0){
			this.die();
		}
		else{
			System.out.println(this.getName() + "'s hp is now " + this.hp);
		}
	}

	/**
	 * <b>die</b><p>automatically called when <b>hp</b> reached <i>ZERO</i></p>
	 */
	public void die(){
		this.setCurrentState(State.DEAD);
		System.out.println(this.getName() + " has died");
		System.out.println(this.getName() + " has dropped: ");
		for(GameItem item : this.inventory.getAll()){
			System.out.println("\t" + item.getName());
		}
	}

	/**
	 * <b>setDialogue</b>
	 * @param dialogue
	 */
	public void setDialogue(String dialogue){
		this.dialogue = dialogue;
	}

	/**
	 * <b>talk</b><p>prints the <b>dialogue</b> of the <b>Creature</b></p>
	 */
	public void talk(){
		System.out.println(this.getName() + ": " + this.dialogue);
	}

	/**
	 * <b>getCurrentState</b>
	 * @return currentState
	 */
	public State getCurrentState() {
		return this.currentState;
	}

	/**
	 * <b>setCurrentState</b>
	 * @param currentState
	 */
	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}

}
