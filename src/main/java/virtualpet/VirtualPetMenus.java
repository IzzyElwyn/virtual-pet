package virtualpet;

public class VirtualPetMenus {
	

	private String startMenu;
	private String mainMenu;
	private String cleanSubMenu;
	private String noteMenu;
	private String multipleMogwaiMenu;
	private String entertainmentSubMenu;
	
	public String getStartMenu() {
		return startMenu;
	}
	
	public String getNoteMenu() {
		return noteMenu;
	}
	
	public String getMainMenu() {
		return mainMenu;
	}
	
	public String getCleanSubMenu() {
		return cleanSubMenu;
	}
	
	public String getMultipleMogwaiMenu() {
		return multipleMogwaiMenu;
	}
	
	public String getEntertainmentSubMenu() {
		return entertainmentSubMenu;
	}

	public VirtualPetMenus() {
		this.startMenu = 
				"You found a mysterious box!\n"
			    + "\nPress 1 to open the box"
			    + "\nPress 2 to walk away";
		this.noteMenu =
				"You've found a Mogwai!\nHe has a name tag that says 'Gizmo' and a small note with him\n"
				+ "\nPress 1 to read the note"
				+ "\nPress 2 to throw the note away";
		this.mainMenu = 
				"What would you like to do with Gizmo?\n" 
				+ "Press 1 to feed Gizmo\n"
				+ "Press 2 to clean Gizmo\n" 
				+ "Press 3 to entertain Gizmo\n" 
				+ "Press 4 to put Gizmo down for a nap\n"
				+ "Press 5 to check on Gizmo\n"
				+ "Press 6 to check the time\n" 
				+ "Press 7 to do nothing\n" 
				+ "Press 8 to exit\n";
		this.cleanSubMenu =
				"How would you like to clean Gizmo?\n"
				+ "Press 1 to give Gizmo a bath\n"
				+ "Press 2 to give Gizmo a dust bath\n"
				+ "Press 3 to return to the main menu\n";
		this.multipleMogwaiMenu = 
				"What would you like to do?\n"
				+ "Press 1 to ask a neighbor to take a mogwai\n"
				+ "Press 2 to check on Gizmo\n"
				+ "Press 3 to check the time\n" ;
		this.entertainmentSubMenu = 
				"What would you like to do with Gizmo?\n"
				+ "Press 1 to sing with Gizmo\n"
				+ "Press 2 to go on a walk with Gizmo\n"
				+ "Press 3 to check the time\n"
				+ "Press 4 to return to the main menu\n";
				
	}

}
