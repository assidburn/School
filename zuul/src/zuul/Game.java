package zuul;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is the main class of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game. Users can walk
 * around some scenery. That's all. It should really be extended to make it more
 * interesting!
 * 
 * To play this game, create an instance of this class and call the "play"
 * method.
 * 
 * This main class creates and initialises all the others: it creates all rooms,
 * creates the parser and starts the game. It also evaluates and executes the
 * commands that the parser returns.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 1.0 (February 2002)
 */

class Game {
	private Parser parser;
	private Room currentRoom;
	private List<Item> myItems;

	/**
	 * Create the game and initialise its internal map.
	 */
	public Game() {
		myItems = new ArrayList<Item>();
		createRooms();
		parser = new Parser();

	}

	/**
	 * Create all the rooms and link their exits together.
	 */
	private void createRooms() {
		Room outside, theatre, pub, lab, office;

		// create the rooms
		// outside = new Room("outside the main entrance of the university");
		// theatre = new Room("in a lecture theatre");
		// pub = new Room("in the campus pub");
		// lab = new Room("in a computing lab");
		// office = new Room("in the computing admin office");
		Room Awing = new Room("in A Wing");
		Room Bathroom = new Room("in boys bathroom");
		Room Commons = new Room("In the lower commons");
		Room OneHallMainHall = new Room("In One hall by main hall");
		Room MainHall = new Room("in main hall");
		Room Cafeteria = new Room("in the cafeteria");
		Room OneHallGalbraithRoom = new Room("In 1 hall outside of mr G's room");
		Room GalbraithRoom = new Room("You're a cool kid because you are in Mr G's room");
		Room OneHallFHall = new Room("in one hall by f hall");
		Room FHall = new Room("in f hall");
		Room OneHallGHall = new Room("standing in ine hall by g hall");
		Room GHall = new Room("standing in g hall");
		Room OneHallHHall = new Room("standing in one hall by h hall");
		Room HHall = new Room("standing in h hall");
		Room OutsideUndercover = new Room("standing outside undercover");
		Room OutsideTables = new Room("standing outside by the tables");
		Room PilleteRoom = new Room("In mr pilettes room");

		MainHall.setExit("north", Bathroom);
		Bathroom.setExit("south", MainHall);

		Awing.setExit("south", OneHallMainHall);
		OneHallMainHall.setExit("north", Awing);
		MainHall.setExit("west", OneHallMainHall);
		OneHallMainHall.setExit("east", MainHall);
		OneHallMainHall.setExit("south", OneHallGalbraithRoom);
		OneHallGalbraithRoom.setExit("north", OneHallMainHall);
		OneHallMainHall.setExit("west", Commons);
		Commons.setExit("east", OneHallMainHall);
		Commons.setExit("south", Cafeteria);
		Cafeteria.setExit("north", Commons);
		Cafeteria.setExit("east", OneHallGalbraithRoom);
		OneHallGalbraithRoom.setExit("east", GalbraithRoom);
		OneHallGalbraithRoom.setExit("west", Cafeteria);
		GalbraithRoom.setExit("west", OneHallGalbraithRoom);
		OneHallGalbraithRoom.setExit("south", OneHallFHall);
		OneHallFHall.setExit("north", OneHallGalbraithRoom);
		OneHallFHall.setExit("east", FHall);
		FHall.setExit("west", OneHallFHall);
		OneHallFHall.setExit("south", OneHallGHall);
		OneHallGHall.setExit("north", OneHallFHall);
		OneHallGHall.setExit("east", GHall);
		GHall.setExit("west", OneHallGHall);
		OneHallGHall.setExit("south", OneHallHHall);
		OneHallHHall.setExit("north", OneHallGHall);
		OneHallHHall.setExit("east", HHall);
		HHall.setExit("west", OneHallHHall);
		OneHallHHall.setExit("north", OneHallGHall);
		OneHallHHall.setExit("south", OutsideUndercover);
		OneHallHHall.setExit("west", PilleteRoom);
		PilleteRoom.setExit("east", OneHallHHall);
		OutsideUndercover.setExit("north", OneHallHHall);
		OutsideUndercover.setExit("west", OutsideTables);
		OutsideTables.setExit("east", OutsideUndercover);
		OutsideTables.setExit("north", PilleteRoom);
		PilleteRoom.setExit("south", OutsideTables);

		// initialise room exits
		// outside.setExit("east", theatre);
		// outside.setExit("south", lab);
		// outside.setExit("west", pub);

		// theatre.setExit("west", outside);
		// theatre.setExit("south", office);

		// pub.setExit("east", outside);

		// lab.setExit("north", outside);
		// lab.setExit("east", office);

		// office.setExit("west", lab);
		// office.setExit("north", theatre);

		OutsideTables.addItem(new Item("fred"));
		FHall.addItem(new Item("george"));
		HHall.addItem(new Item("GeneralSinclair"));
		GHall.addItem(new Item("barnaby waters"));
		Cafeteria.addItem(new Item("adrian beaky"));

		currentRoom = Awing; // start game A Wing
		currentRoom = OutsideTables;
	}

	/*
	 * Main play routine. Loops until end of play.
	 */
	public void play() {
		printWelcome();

		// Enter the main command loop. Here we repeatedly read commands and
		// execute them until the game is over.

		boolean finished = false;
		while (!finished) {
			Command command = parser.getCommand();
			finished = processCommand(command);
		}
		System.out.println("Thank you for playing.  Good bye.");
	}

	/**
	 * Print out the opening message for the player.
	 */
	private void printWelcome() {
		System.out.println();
		System.out.println("Welcome to Adventure!");
		System.out.println("Adventure is a new, incredibly boring adventure game,"
				+ " find fred, george, General Sinclair, Captain Barnaby Waters, and Sir Adrian Beaky "
				+ "and take them to the boys bathroom in main hall.");
		System.out.println("Type 'help' if you need help.");
		System.out.println();
		System.out.println(currentRoom.getLongDescription());
	}

	/**
	 * Given a command, process (that is: execute) the command. If this command
	 * ends the game, true is returned, otherwise false is returned.
	 */
	private boolean processCommand(Command command) {
		boolean wantToQuit = false;

		if (command.isUnknown()) {
			System.out.println("I don't know what you mean...");
			return false;
		}

		String commandWord = command.getCommandWord();
		if (commandWord.equals("help"))
			printHelp();
		else if (commandWord.equals("go"))
			goRoom(command);
		else if (commandWord.equals("pickup"))
			pickup(command);
		else if (commandWord.equals("drop"))
			wantToQuit = drop(command);
		else if (commandWord.equals("quit")) {
			wantToQuit = quit(command);}
			else if (commandWord.equals("show")) {
				wantToQuit = show(command);
		}
		return wantToQuit;
	}

	// implementations of user commands:

	private boolean show(Command command) {
		// TODO Auto-generated method stub
		String returnString = ".  show ";
		for (Item i : myItems)
			returnString += i.name;
		System.out.println(returnString);
		
		
		
		return false;
	}

	/**
	 * Print out some help information. Here we print some stupid, cryptic
	 * message and a list of the command words.
	 */
	private void printHelp() {
		System.out.println("You are lost. You are alone. You wander");
		System.out.println("around at the university.");
		System.out.println();
		System.out.println("Your command words are:");
		parser.showCommands();
	}

	private void pickup(Command command) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			System.out.println("Pickup what?");
			return;
		}

		String thing = command.getSecondWord();

		if (!currentRoom.hasItem(thing)) {
			System.out.println("Pickup what?");
			return;
		}

		Item i = currentRoom.takeItem(thing);

		myItems.add(i);
	}

	private boolean drop(Command command) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			System.out.println("Drop what?");
			return false;
		}

		String thing = command.getSecondWord();

		for (Item i : myItems)
			if (i.name.equals(thing)) {
				if (thing.equals("fred")) {
					if (currentRoom.getShortDescription() == "in boys bathroom")
						return true;
				}
			}

		for (Item i : myItems)
			if (i.name.equals(thing)) {
				myItems.remove(i);
				currentRoom.addItem(i);
				return false;
			}

		return false;
	}

	/**
	 * Try to go to one direction. If there is an exit, enter the new room,
	 * otherwise print an error message.
	 */
	private void goRoom(Command command) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			System.out.println("Go where?");
			return;
		}

		String direction = command.getSecondWord();

		// Try to leave current room.
		Room nextRoom = currentRoom.getExit(direction);

		if (nextRoom == null)
			System.out.println("There is no door!");
		else {
			currentRoom = nextRoom;
			System.out.println(currentRoom.getLongDescription());
		}
	}

	/**
	 * "Quit" was entered. Check the rest of the command to see whether we
	 * really quit the game. Return true, if this command quits the game, false
	 * otherwise.
	 */
	private boolean quit(Command command) {
		if (command.hasSecondWord()) {
			System.out.println("Quit what?");
			return false;
		} else
			return true; // signal that we want to quit
	}
}
