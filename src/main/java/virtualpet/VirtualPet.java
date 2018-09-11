package virtualpet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VirtualPet {

	Random rand = new Random();

	List<OtherMogwai> mogwai = new ArrayList<>();

	private int hunger;
	private int cleanliness;
	private int boredom;
	private int tiredness;
	private boolean isGremlin;
	private boolean isAlive;
	private int tickLog;

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

	public boolean getIsGremlin() {
		return isGremlin;
	}

	public boolean getIsAlive() {
		return isAlive;
	}

	public int getTickLog() {
		return tickLog;
	}

	public VirtualPet() {
		this.hunger = 100;
		this.cleanliness = 100;
		this.boredom = 100;
		this.tiredness = 100;
		this.isGremlin = false;
		this.isAlive = true;
		this.tickLog = 0;
	}

	public void feed() {
		if (checkHourOfDay() >= 0 && checkHourOfDay() <= 6) {
			isGremlin = true;
		} else if (getHunger() + 25 > 100) {
			hunger = 100;
		} else {
			hunger += 25;
		}
	}

	public void dustBath() {
		cleanliness = 100;
	}

	public void waterBath() {
		mogwai.add(new OtherMogwai());
		mogwai.add(new OtherMogwai());
		mogwai.add(new OtherMogwai());
	}

	public void singWithMogwai() throws InterruptedException {
		System.out.println("Gizmo has a lovely singing voice!\n");
		System.out.println(" \\TT\\~~/TT/    * *     ");
		System.out.println("   (_^o^_)  * *          ");
		System.out.println("  <({ _ })>              ");
		System.out.println("   |_| |_|             \n");
		Thread.sleep(10000);
		if (getBoredom() + 25 > 100) {
			boredom = 100;
		} else {
			boredom += 25;
		}
	}

	public void walkWithMogwai() {
		if (checkHourOfDay() > 6 && checkHourOfDay() < 20) {

			setIsAlive(false);

		} else {
			if (getBoredom() + 50 > 100) {
				boredom = 100;
			} else {
				boredom += 50;
			}
		}

	}

	public String burnsUp() {

		System.out.println("      ((    ");
		System.out.println("       ))   ");
		System.out.println("      //    ");
		System.out.println("     (      ");
		System.out.println("   )        ");
		System.out.println("  ) \\      ");
		System.out.println(" /   (      ");
		System.out.println(" \\(_)/   \n");
		return "Gizmo burned to a crisp in the sunlight .... Game Over";

	}

	private void setIsAlive(boolean isStillAlive) {
		isAlive = false;
		
	}

	public void rest() throws InterruptedException {
		System.out.println("Shhhh....Gizmo is Sleeping\n");
		System.out.println(" <TT\\~~/TT>   Z Z  ");
		System.out.println("  (_-_-_)  z z	    ");
		System.out.println(" <({ _ })>          ");
		System.out.println("  |_| |_|         \n");
		int restTime = (100 - getTiredness()) * 200;
		Thread.sleep(restTime);
		tiredness = 100;

	}

	public String getStatus() {
		return "\nGizmo is at:" + "\nHunger: " + getHunger() + "\nCleanliness: " + getCleanliness() + "\nBoredom: "
				+ getBoredom() + "\nTiredness: " + getTiredness();
	}

	public String getMood() {
		if (!getIsGremlin()) {

			if ((hunger) <= 40 || boredom <= 40 || cleanliness <= 40 || tiredness <= 40) {

				System.out.println(" <TT\\~~/TT>");
				System.out.println("  (_;_;_)	");
				System.out.println(" <({ _ })>  ");
				System.out.println("  |_| |_| \n");
				return "Gizmo is Sad\n";
			} else if ((hunger <= 80 && hunger > 40) || (boredom <= 80 && boredom > 40)
					|| (cleanliness <= 80 && cleanliness > 40) || (tiredness <= 80 && cleanliness > 40)) {

				System.out.println("\\TT\\~~/TT/");
				System.out.println("  (_0_0_)   ");
				System.out.println(" <({ _ })>  ");
				System.out.println("  |_| |_| \n");
				return "Gizmo is Okay\n";
			} else {
				System.out.println(" \\TT\\~~/TT/ ");
				System.out.println("   (_^o^_)    ");
				System.out.println("  <({ _ })>   ");
				System.out.println("   |_| |_|  \n");
				return "Gizmo is Happy\n";
			}
		} else {
			System.out.println("    <TTTTWTTTT>     ");
			System.out.println("      \\* w */      ");
			System.out.println("___w__[_____]_w_____");
			return "Gizmo is now a Gremlin.... Game Over";
		}

	}

	public String otherMogwaiPresent() {
		System.out.println(" <TT\\~~/TT> ");
		System.out.println("   (_@.@_)   ");
		System.out.println("  <({ _ })>  ");
		System.out.println("   |_| |_| \n");
		return "There are now " + getNumMogwais() + " Mogwai in the house...\n";
	}

	public int getNumMogwais() {
		return mogwai.size() + 1;
	}

	public String otherMogwaiGremlinsArt() {
		System.out.println("    <TTTTWTTTT>     ");
		System.out.println("     \\* w */       ");
		System.out.println("___w_[______]_w_____");
		return "The other mogwai turned into a Gremlin... Game Over";
	}

	public boolean otherMogwaiAreGremlins() {
		OtherMogwai gremlin = new OtherMogwai();
		gremlin.setIsGremlin(true);
		return gremlin.getIsGremlin();
	}

	public String offerOtherMogwaiToNeighbor() {
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

	public void tick() throws InterruptedException {
		int randomTick = rand.nextInt(5) + 1;
		if (getHunger() - randomTick < 0) {
			hunger = 0;
		} else {
			hunger -= randomTick;
		}
		if (getCleanliness() - randomTick < 0) {
			cleanliness = 0;
		} else {
			cleanliness -= randomTick;
		}
		if (getBoredom() - randomTick < 0) {
			boredom = 0;
		} else {
			boredom -= randomTick;
		}
		if (getTiredness() - randomTick <= 0) {
			rest();
		} else {
			tiredness -= randomTick;
		}

		tickLog += randomTick;

		if (tickLog > 120) {
			tickLog = tickLog - 120;
		}
	}

	public int checkHourOfDay() {
		int hourOfDay = (tickLog / 5);
		return hourOfDay;
	}

	public String checkTime() {
		int hourOfDay = (tickLog / 5);
		if (hourOfDay >= 1 && hourOfDay < 2) {
			return "It is 1 AM";
		} else if (hourOfDay >= 2 && hourOfDay < 3) {
			return "It is 2 AM";
		} else if (hourOfDay >= 3 && hourOfDay < 4) {
			return "It is 3 AM";
		} else if (hourOfDay >= 4 && hourOfDay < 5) {
			return "It is 4 AM";
		} else if (hourOfDay >= 5 && hourOfDay < 6) {
			return "It is 5 AM";
		} else if (hourOfDay >= 6 && hourOfDay < 7) {
			return "It is 6 AM";
		} else if (hourOfDay >= 7 && hourOfDay < 8) {
			return "It is 7 AM";
		} else if (hourOfDay >= 8 && hourOfDay < 9) {
			return "It is 8 AM";
		} else if (hourOfDay >= 9 && hourOfDay < 10) {
			return "It is 9 AM";
		} else if (hourOfDay >= 10 && hourOfDay < 11) {
			return "It is 10 AM";
		} else if (hourOfDay >= 11 && hourOfDay < 12) {
			return "It is 11 AM";
		} else if (hourOfDay >= 12 && hourOfDay < 13) {
			return "It is 12 PM";
		} else if (hourOfDay >= 13 && hourOfDay < 14) {
			return "It is 1 PM";
		} else if (hourOfDay >= 14 && hourOfDay < 15) {
			return "It is 2 PM";
		} else if (hourOfDay >= 15 && hourOfDay < 16) {
			return "It is 3 PM";
		} else if (hourOfDay >= 16 && hourOfDay < 17) {
			return "It is 4 PM";
		} else if (hourOfDay >= 17 && hourOfDay < 18) {
			return "It is 5 PM";
		} else if (hourOfDay >= 18 && hourOfDay < 19) {
			return "It is 6 PM";
		} else if (hourOfDay >= 19 && hourOfDay < 20) {
			return "It is 7 PM";
		} else if (hourOfDay >= 20 && hourOfDay < 21) {
			return "It is 8 PM";
		} else if (hourOfDay >= 21 && hourOfDay < 22) {
			return "It is 9 PM";
		} else if (hourOfDay >= 22 && hourOfDay < 23) {
			return "It is 10 PM";
		} else if (hourOfDay >= 23 && hourOfDay < 24) {
			return "It is 11 PM";
		} else {
			return "It is 12 AM";
		}
	}

}
