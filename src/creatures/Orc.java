package creatures;

public class Orc extends Creature {

	public static final int DEFAULT_HP = 125;
	
	public Orc(){
		super();
	}
	
	public Orc(String name){
		super(name);
	}
	
	public String getRace(){
		return "Orc";
	}
	
}
