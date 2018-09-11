package virtualpet;

import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) throws InterruptedException {

		Scanner input = new Scanner(System.in);
		VirtualPetMenus menu = new VirtualPetMenus();
		int menuOption;

		System.out.println(menu.getStartMenu());
		int chooseToPlay = input.nextInt();
		input.hasNextLine();
		if (chooseToPlay == 2) {
			System.out.println("How unadventurous of you...");
			System.exit(0);
		}

		VirtualPet gizmo = new VirtualPet();

		System.out.println(menu.getNoteMenu());
		int chooseToRead = input.nextInt();
		input.hasNextLine();

		if (chooseToRead == 1) {
			System.out.println("The Note Reads: " + "\n\"Follow These Three Rules At All Costs"
					+ "\n1. Never Get Gizmo Wet" + "\n2. Never Take Gizmo Out In The Sun"
					+ "\n3. Never Ever Feed A Mogwai After Midnight\"\n\n\n\n\n");
			Thread.sleep(14000);
		}

		do {
			System.out.println(gizmo.getMood());
			System.out.println(menu.getMainMenu());
			menuOption = input.nextInt();

			switch (menuOption) {
			case 1:
				gizmo.feed();
				gizmo.tick();
				break;
			case 2:
				System.out.println(menu.getCleanSubMenu());
				int cleanSubMenuChoice = input.nextInt();
				input.nextLine();
				if (cleanSubMenuChoice == 1) {
					gizmo.waterBath();
					do {
					System.out.println(gizmo.otherMogwaiPresent());
					System.out.println(menu.getMultipleMogwaiMenu());
					int multipleMogwaiMenuChoice = input.nextInt();
					input.nextLine();
					switch (multipleMogwaiMenuChoice) {
					case 1: System.out.println(gizmo.offerOtherMogwaiToNeighbor());
							gizmo.tick();
					break;
					case 2: gizmo.getStatus(); 
							gizmo.tick();
					break;
					case 3: System.out.println(gizmo.checkTime());
							Thread.sleep(30000);
							gizmo.tick();
					break;
					default: System.out.println(" ");
							 gizmo.tick();
					}
					
					} while (gizmo.getNumMogwais() > 1);
			
					
				} else if (cleanSubMenuChoice == 2) {
					gizmo.dustBath();
				}
				gizmo.tick();
				break;
			case 3:
				System.out.println(menu.getEntertainmentSubMenu());
				int entertainmentSubMenuChoice = input.nextInt();
				input.nextLine();
				switch (entertainmentSubMenuChoice) {
				case 1:
						gizmo.singWithMogwai();
						gizmo.tick();
						break;
				case 2: 
						gizmo.walkWithMogwai();
						gizmo.tick();
						break;
				case 3: System.out.println(gizmo.checkTime());
						gizmo.tick();
					break;
				default: gizmo.tick();
						System.out.println(" ");
				}
				gizmo.tick();
				break;
			case 4:
				gizmo.rest();
				gizmo.tick();
				break;
			case 5: 
				System.out.println(gizmo.getStatus());
				gizmo.tick();
				break;
			case 6:
				System.out.println(gizmo.checkTime());
				gizmo.tick();
			default: 
				gizmo.tick();
				input.nextLine();
			}

		} while (menuOption != 8 && !gizmo.getIsGremlin());
		if (gizmo.getIsGremlin()) {
			System.out.println(gizmo.getMood());
			System.exit(0);
		} else {
			
			System.out.println("See you later, Gizmo!");

		input.close();
		}
	}

}
