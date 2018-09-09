package virtualpet;

import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) throws InterruptedException {

		Scanner input = new Scanner(System.in);
		String mainMenu;
		int menuOption;

		System.out.println("You found a mysterious box!");

		Thread.sleep(50);

		System.out.println("Press 1 to open the box\nPress 2 to walk away");
		int chooseToPlay = input.nextInt();
		input.hasNextLine();

		if (chooseToPlay == 2) {

			System.out.println("How unadventurous of you...");
			System.exit(0);

		}
		
		VirtualPet gizmo = new VirtualPet();

		System.out.println("You've found a Mogwai!\nHe has a nametag that says 'Gizmo' and a small note with him");
		Thread.sleep(50);
		System.out.println("Press 1 to read the note\nPress 2 to throw the note away");
		int chooseToRead = input.nextInt();
		input.hasNextLine();

		if (chooseToRead == 1) {
			System.out.println(
					"The Note Reads: \n\"Follow These Three Rules:\n1. Never Get Gizmo Wet\n2. Never Take Gizmo Out In The Sun\n3. Never Ever Feed A Mogwai After Midnight\"\n\n\n\n");
			Thread.sleep(20000);
		}

		// Begin Game Loop Here - I think???//
				mainMenu = 
				"What would you like to do with Gizmo?\n" 
				+ "Press 1 to Feed Gizmo\n"
				+ "Press 2 to Clean Gizmo\n" 
				+ "Press 3 to Entertain Gizmo\n" 
				+ "Press 4 put Gizmo Down for a Nap\n"
				+ "Press 5 to Check the Time\n" 
				+ "Press 6 to do Nothing\n" 
				+ "Press 7 to Exit\n";

		do {
			System.out.println(gizmo.getMood());
			System.out.println(mainMenu);
			menuOption = input.nextInt();
			

		} while (menuOption != 7);

		input.close();
	}

}
