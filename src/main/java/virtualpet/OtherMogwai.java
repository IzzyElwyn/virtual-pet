package virtualpet;

public class OtherMogwai {

	private int hunger;
	private boolean isItAGremlin;

	
	public int getHunger() {
		return hunger;
	}
	
	public boolean getIsItAGremlin() {
		return isItAGremlin;
	}
	
	public OtherMogwai() {
		this.hunger = 100;
		this.isItAGremlin = false;
	}
	
	public OtherMogwai(int hunger, boolean isItAGremlin) {
		this.hunger = hunger;
		this.isItAGremlin = isItAGremlin;
	}

	public void setHunger(int newHunger) {
		hunger = newHunger;
		
	}

}
