package creatures;

public class Human extends Creature{
	
	public static final int DEFAULT_HP = 85;
	
	public Human(){
		super();
	}
	
	public Human(String name){
		super(name);
	}
	
	public String getRace(){
		return "Human";
	}
	
}
