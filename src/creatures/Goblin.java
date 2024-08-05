package creatures;

public class Goblin extends Creature{
	
	public static final int DEFAULT_HP = 70;
	
	public Goblin(){
		super();
	}
	
	public Goblin(String name){
		super(name);
	}
	
	public String getRace(){
		return "Goblin";
	}

}
