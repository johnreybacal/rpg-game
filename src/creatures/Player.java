package creatures;

public class Player extends Fighter{

	Player(String name){
		super(name);
	}
	
	public Player(String name, Creature creature){
		super(name);
		this.creature = creature;
	}
	
	public void attack(Creature creature){
		if(this.isAlive()){
			if(creature.isAlive()){
				if(creature instanceof Fighter){
					super.attack(creature);
				}
				else{
					System.out.println(creature.getName() + " is not looking "
							+ "for a fight");
				}
			}
			else{
				System.out.println(creature.getName() + " is already dead");
			}
		}
		else{
			System.out.println(this.getName() + " is dead");
		}
	}
	
	public void defend(){
		if(this.isAlive()){
			super.defend();
		}
		else{
			System.out.println(this.getName() + " is dead");
		}
	}
	
}
