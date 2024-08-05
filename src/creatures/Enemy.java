package creatures;

public class Enemy extends Fighter{

	Enemy(String name){
		super(name);
	}
	
	public Enemy(String name, Creature creature){
		super(name);
		this.creature = creature;
	}
	
	public void attack(Creature creature){
		if(!this.equals(creature)){
			if(this.isAlive()){
				if(creature.isAlive()){
					if(creature instanceof Fighter){
						super.attack(creature);
					}else{
						System.out.println(this.getName() + " attacked "
								+ creature.getName() + " with a "
								+ this.weapon.getName());
						creature.decreaseHP(this.weapon.getDamage());
						if(!creature.isAlive()){
							System.out.println(creature.getName() + " was killed "
									+ "by " + this.getName());
						}
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
		else{
			System.out.println(this.getName() + " is thinking of attacking"
					+ " itself");
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
