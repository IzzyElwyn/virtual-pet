package virtualpet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VirtualPet {

	List<OtherMogwai> mogwai = new ArrayList<>();

	private int hunger;
	private int cleanliness;
	private int boredom;
	private int tiredness;

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

	public VirtualPet() {
		this.hunger = 100;
		this.cleanliness = 100;
		this.boredom = 100;
		this.tiredness = 100;
	}

	public void feed() {
		hunger += 5;
	}

	public void dustBath() {
		cleanliness = 100;
	}

	public void waterBath() {
		addMogwai(new OtherMogwai());
		addMogwai(new OtherMogwai());
		addMogwai(new OtherMogwai());
	}

	public void singWithMogwai() {
		boredom += 25;

	}

	public void walkWithMogwai() {
		boredom += 50;

	}

	public void rest(int time) {
		tiredness += time;
	}


	public String getMood() {

		if ((hunger) <= 40 || boredom <= 40 || cleanliness <= 40 || tiredness <= 40) {

			System.out.println(" <TT\\~~/TT>");
			System.out.println("  (_;_;_)	");
			System.out.println(" <({ _ })>  ");
			System.out.println("  |_| |_|   ");
			return "Gizmo is Sad";
		} else if ((hunger <= 80 && hunger > 40) || (boredom <= 80 && boredom > 40)
				|| (cleanliness <= 80 && cleanliness > 40) || (tiredness <= 80 && cleanliness > 40)) {

			System.out.println("\\TT\\~~/TT/");
			System.out.println("  (_0_0_)   ");
			System.out.println(" <({ _ })>  ");
			System.out.println("  |_| |_|   ");
			return "Gizmo is Okay";
		} else {
			System.out.println(" \\TT\\~~/TT/ ");
			System.out.println("   (_^o^_)    ");
			System.out.println("  <({ _ })>   ");
			System.out.println("   |_| |_|    ");
			return "Gizmo is Happy";
		}

	}

	public void addMogwai(OtherMogwai mogwais) {
		mogwai.add(mogwais);
	}
	
	public int getNumMogwais() {
		return mogwai.size() + 1;
	}

	public int[] checkOtherMogwaiHunger() {
		int i = 0;
		int[] hungerGauge = new int[mogwai.size()];
		for (OtherMogwai mogwais : mogwai) {
			hungerGauge[i] = mogwais.getHunger();
			i++;
		}
		return hungerGauge;
	}


	public String offerOtherMogwaiToNeighbor() {
		Random rand = new Random();
		int randomNumber = rand.nextInt(100) + 1;
		if ((randomNumber % 2) == 0) {
			giveAwayMogwai();
			return "Your Neighbor Accepted The Mogwai!";
		} else {
			return "Your Neighbor Rejected The Mogwai...";
		}
	}

	public void giveAwayMogwai() {
		int i = mogwai.size() - 1;
		mogwai.remove(i);
		
	}
	public void tick(int time) {
		hunger -= time;
		cleanliness -= time;
		boredom -= time;
		tiredness -= time;
		if (mogwai.size() > 0) {
			int oldHunger;
			int newHunger;
			for (int i = 0; i < mogwai.size(); i++) {
				oldHunger = mogwai.get(i).getHunger();
				newHunger = oldHunger -= (time * 3);
				mogwai.get(i).setHunger(newHunger);
			}
		}
	}
}
