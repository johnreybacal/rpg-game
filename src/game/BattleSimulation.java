package game;

/**
 * <b>BattleSimulation</b>
 * <p>simulates in game battle</p> 
 *
 * @version 1.0
 * @author Johnrey Bacal [jbacal@tspi.com.ph]
 */
import java.util.ArrayList;
import java.util.List;

import creatures.*;

/**
 * <b>BattleSimulation</b>
 * @version 1.0
 * @author Johnrey Bacal [jbacal@tspi.com.ph]
 */
public class BattleSimulation {

	/**
	 * <b>fighters</b>
	 * <p>list of all fighters present in the battle simulation</b>
	 */
	private ArrayList<Fighter> fighters;
	
	/**
	 * <b>isFreeForAll</b><p>flag is the battle is in free for all mode</p>
	 */
	private boolean isFreeForAll;
	
	/**
	 * <b>INITIAL_TIME_LAPSE</b>
	 * <p>for speed mechanization of the fighters in the battle simulation</p>
	 */
	private static final int INITIAL_TIME_LAPSE = 100;
	
	/**
	 * <b>Class Constructor</b>
	 * @param fighters <p>set the fighters present</p>
	 * @param isFreeForAll <p>set the battle mode</p>
	 */
	BattleSimulation(ArrayList<Fighter> fighters, boolean isFreeForAll){
		this.isFreeForAll = isFreeForAll;
		this.fighters = fighters;
		for(Fighter f : fighters){
			f.moveIndex = f.getSpeed();
		}
	}
	
	/**
	 * <b>simulateBattle</b><p>simulates the battle</p>
	 */
	public void simulateBattle(){
		boolean battleOver = false;
		List<Fighter> dead = new ArrayList<Fighter>();
		int timeLapse = INITIAL_TIME_LAPSE;
		ArrayList<Fighter> fighters = new ArrayList<Fighter>();
		do {

			timeLapse = nextTimeLapse(timeLapse);
			fighters = this.checkTurn(timeLapse);
			
			for(Fighter f : fighters){
				dead.clear();
				
				if(f.isAlive()){
					f.decide(this.fighters, isFreeForAll);					
				}
				for(Fighter other : this.fighters){//gather fighter who just died
					if(!other.isAlive()){
						dead.add(other);
					}
				}
				for(Fighter fallen : dead){//remove dead fighters
					this.fighters.remove(fallen);
				}
				
				if(isFreeForAll){//checks if game is over
					if(this.fighters.size() == 1){
						battleOver = true;
					}
				}
				else if(!hasPlayers() || !hasEnemies()){
					if(this.fighters.size() > 1){
						isFreeForAll = true;
						System.out.println("-----------------------------------------------\n"
								+ "Diety has been slain,");
						for(Fighter rf : this.fighters){
							System.out.println("\t" + rf.getName());
						}
						System.out.println("\t\tlooked at each other menacingly");
						System.out.println("\t\tfor whoever dons Diety's weapon");
						System.out.println("\t\tand armor shall become absolute");
						System.out.println("-----------------------------------------------");
						System.out.println("\tTHE BATTLE FOR POWER BEGINS!!!");
					}
					else{
						battleOver = true;						
					}
				}
			}
			if(timeLapse == 0){
				timeLapse = INITIAL_TIME_LAPSE;
			}
			fighters.clear();
		} while(!battleOver);
		System.out.println("\n---------------------------------\n"
				+ "As the dust settles,");
		for(Fighter f : this.fighters){
			System.out.println("\t" + f.getName());
		}
		System.out.println("\t\tremained standing");
		System.out.println("---------------------------------\n");
	}
	
	/**
	 * <b>checkTurn</b>
	 * @param timeLapse <p>current time lapse</p>
	 * @return fighters <p>whose going to take their turn</p>
	 */
	public ArrayList<Fighter> checkTurn(final int timeLapse){
		ArrayList<Fighter> fighters = new ArrayList<Fighter>();
		for(int i = 0; i < this.fighters.size(); i++){
			int moveIndex = this.fighters.get(i).moveIndex;
			if(timeLapse == moveIndex){
				moveIndex -= INITIAL_TIME_LAPSE 
						- this.fighters.get(i).getSpeed();
				if(moveIndex < 0){
					moveIndex = INITIAL_TIME_LAPSE + moveIndex;
				}
				this.fighters.get(i).moveIndex = moveIndex;
				fighters.add(this.fighters.get(i));
			}
		}
		return fighters;
	}
	
	/**
	 * <b>nextTimeLapse</p>
	 * @param timeLapse
	 * @return timeLapse 
	 * <p>the next time lapse where a fighter is to take their turn</p>
	 */
	public int nextTimeLapse(int timeLapse){
		int next = 0;
		for(Fighter f : this.fighters){
			if(f.moveIndex > next && f.moveIndex < timeLapse){
				next = f.moveIndex;
			}
		}
		return next;
	}
	
	/**
	 * <p>hasPlayers</p>
	 * @return boolean <p>if there are fighters of type <b>Player</b> left</p>
	 */
	public boolean hasPlayers(){
		boolean hasPlayers = false;
		for(Fighter f : this.fighters){
			if(f instanceof Player){
				hasPlayers = true;
				break;
			}
		}
		return hasPlayers;
	}

	/**
	 * <p>hasEnemies</p>
	 * @return boolean <p>if there are fighters of type <b>Enemy</b> left</p>
	 */
	public boolean hasEnemies(){
		boolean hasEnemies = false;
		for(Fighter f : this.fighters){
			if(f instanceof Enemy){
				hasEnemies = true;
				break;
			}
		}
		return hasEnemies;
	}
}
