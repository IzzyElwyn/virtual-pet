package virtualpet;


public class VirtualPet {


	private int hunger;
	private int cleanliness;
	private int boredom;
	private int tiredness;
	private int numMogwais;
	
	public int getNumMogwais() {
		return numMogwais;
	}

	public int getHunger() {
		return hunger;
	}

	public int getCleanliness() {
		return cleanliness;
	}

	public int getBoredom() {
		return boredom;
	}

	public int getTiredness() {
		return tiredness;
	}
	
	public VirtualPet(int numMogwais) {
		this.numMogwais = numMogwais;
		this.hunger = 100;
		this.cleanliness = 100;
		this.boredom = 100;
		this.tiredness = 100;
	}

	public void tick(int time) {
		hunger -= time;
		cleanliness -= time;
		boredom -= time;
		tiredness -= time;

	}

	public void feed() {
		hunger += 5;

	}

	public void dustBath() {
		cleanliness = 100;

	}

	public void Sing() {
		boredom += 25;

	}

	public void rest(int time) {
		tiredness += time;
		
	}

	public void waterBath() {
		numMogwais += 3;
		
		
	}



}
