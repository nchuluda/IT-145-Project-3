import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Driver {

    // instance variables (add more as needed)
    private static ArrayList<Ship> shipList = new ArrayList();
    private static ArrayList<Cruise> cruiseList = new ArrayList();
    private static ArrayList<Passenger> passengerList = new ArrayList();


    public static void main(String[] args) {

        initializeShipList();       // initial ships
        initializeCruiseList();     // initial cruises
        initializePassengerList();  // initial passengers
        
        
        // New scanner for menu input
    	Scanner menu = new Scanner(System.in);

    	// Loop prompts for user input, displays selected information,
    	// then returns to main menu until user exits by entering 'x'
        Boolean exitMenu = false;
        while(!exitMenu) {
        	displayMenu();
        	String menuSelection = menu.next();
        	// drop anything after first character of user input
        	char menuSingleChar = menuSelection.charAt(0);
        	switch(menuSingleChar) {
        	case '1':
        		addShip();
        		break;
        	case '2':
        		editShip();
        		break;
        	case '3':
        		addCruise();
        		break;
        	case '4':
        		editCruise();
        		break;
        	case '5':
        		addPassenger();
        		break;
        	case '6': 
        		editPassenger();
        		break;
        	case 'a':
        	case 'A':
        		printShipList("name");
        		break;
        	case 'b':
        	case 'B':
        		printShipList("active");
        		break;
        	case 'c':
        	case 'C':
        		printShipList("full");
        		break;
        	case 'd':
        	case 'D':
        		printCruiseList("list");
        		break;
        	case 'e':
        	case 'E':
        		printCruiseList("details");
        		break;
        	case 'f':
        	case 'F':
        		printPassengerList();
        		break;
        	// Exit is the only option that will not display menu after input
        	case 'x':
        	case 'X':
        		System.out.println("Exiting.");
        		exitMenu = true;
        		break;
        	// If user enters anything besides a valid menu option
        	default:
        		System.out.println("Please enter a valid menu selection.");
        		break;
        	}
        }

        // add loop and code here that accepts and validates user input
        // and takes the appropriate action. include appropriate
        // user feedback and redisplay the menu as needed


    }

    // hardcoded ship data for testing
    // Initialize ship list
    public static void initializeShipList() {
        add("Candy Cane", 20, 40, 10, 60, 260, true);
        add("Peppermint Stick", 10, 20, 5, 40, 150, true);
        add("Bon Bon", 12, 18, 2, 24, 112, false);
        add("Candy Corn", 12, 18, 2, 24, 112, false);
    }

    // hardcoded cruise data for testing
    // Initialize cruise list
    public static void initializeCruiseList() {
        Cruise newCruise = new Cruise("Southern Swirl", "Candy Cane", "Miami", "Cuba", "Miami");
        cruiseList.add(newCruise);
        Cruise cruise2 = new Cruise("Baltic Seas", "Bon Bon", "Stockholm", "Bergen", "Copenhagen");
        cruiseList.add(cruise2);
    }

    // hardcoded cruise data for testing
    // Initialize passenger list
    public static void initializePassengerList() {
        Passenger newPassenger1 = new Passenger("Neo Anderson", "Southern Swirl", "STE");
        passengerList.add(newPassenger1);

        Passenger newPassenger2 = new Passenger("Trinity", "Southern Swirl", "STE");
        passengerList.add(newPassenger2);

        Passenger newPassenger3 = new Passenger("Morpheus", "Southern Swirl", "BAL");
        passengerList.add(newPassenger3);
    }

    // custom method to add ships to the shipList ArrayList
    public static void add(String tName, int tBalcony, int tOceanView,
                           int tSuite, int tInterior, int tMaxPassengers, boolean tInService) {
        Ship newShip = new Ship(tName, tBalcony, tOceanView, tSuite, tInterior, tMaxPassengers, tInService);
        shipList.add(newShip);
    }


    public static void printShipList(String listType) {
        // printShipList() method prints list of ships from the
        // shipList ArrayList. There are three different outputs
        // based on the listType String parameter:
        // name - prints a list of ship names only
        // active - prints a list of ship names that are "in service"
        // full - prints tabbed data on all ships

        if (shipList.size() < 1) {
            System.out.println("\nThere are no ships to print.");
            return;
        }
        if (listType == "name") {
            System.out.println("\n\nSHIP LIST - Name");
            for (int i = 0; i < shipList.size(); i++) {
                System.out.println(shipList.get(i));
            }
        } else if (listType == "active") {
            System.out.println("\n\nSHIP LIST - Active");
            System.out.println("----------------------------------------------------------------");
            System.out.println("                    Number of Rooms    		 	In");
            System.out.print("SHIP NAME           Bal\tOV\tSte\tInt\t\tService");
            System.out.println("\n----------------------------------------------------------------");
            // complete this code block
            // Iterates through shipList ArrayList and prints if ship is active (inService == true)
            for (Ship eachShip: shipList) {
            	if (eachShip.getInService() == true) {
            		eachShip.printShipData();
            	}
            }
            


        } else if (listType == "full") {
            System.out.println("\n\nSHIP LIST - Full");
            System.out.println("----------------------------------------------------------------");
            System.out.println("                    Number of Rooms    		 	In");
            System.out.print("SHIP NAME           Bal\tOV\tSte\tInt\t\tService");
            System.out.println("\n----------------------------------------------------------------");
            for (Ship eachShip: shipList)
                eachShip.printShipData();

        } else
            System.out.println("\n\nError: List type not defined.");
    }

    public static void printCruiseList(String listType) {
        if (cruiseList.size() < 1) {
            System.out.println("\nThere are no cruises to print.");
            return;
        }
        if (listType == "list") {
            System.out.println("\n\nCRUISE LIST");
            for (int i=0; i < cruiseList.size(); i++) {
                System.out.println(cruiseList.get(i));
            }
        } else if (listType == "details") {
            System.out.println("\n\nCRUISE LIST - Details");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("                                      |----------------------PORTS-----------------------|");
            System.out.print("CRUISE NAME         SHIP NAME           DEPARTURE           DESTINATION         RETURN");
            System.out.println("\n-----------------------------------------------------------------------------------------");
            for (Cruise eachCruise: cruiseList)
                eachCruise.printCruiseDetails();
        } else
            System.out.println("\n\nError: List type not defined.");
    }

    public static void printPassengerList() {
        if (passengerList.size() < 1) {
            System.out.println("\nThere are no passengers to print.");
            return;
        }
        System.out.println("\n\nPASSENGER LIST");
        System.out.println("-----------------------------------------------------");
        System.out.print("PASSENGER NAME      CRUISE              ROOM TYPE");
        System.out.println("\n-----------------------------------------------------");
        for (Passenger eachPassenger: passengerList)
            eachPassenger.printPassenger();
    }

    // display text-based menu
    public static void displayMenu() {

        System.out.println("\n\n");
        System.out.println("\t\t\tLuxury Ocean Cruise Outings");
        System.out.println("\t\t\t\t\tSystem Menu\n");
        System.out.println("[1] Add Ship            [A] Print Ship Names");
        System.out.println("[2] Edit Ship           [B] Print Ship In Service List");
        System.out.println("[3] Add Cruise          [C] Print Ship Full List");
        System.out.println("[4] Edit Cruise         [D] Print Cruise List");
        System.out.println("[5] Add Passenger       [E] Print Cruise Details");
        System.out.println("[6] Edit Passenger      [F] Print Passenger List");
        System.out.println("[x] Exit System");
        System.out.println("\nEnter a menu selection: ");
    }

    // Add a New Ship
    public static void addShip() {

        // complete this method
    	Scanner newShipInput = new Scanner(System.in);
    	// prompt user to enter ship name
    	System.out.println("Enter the new ship's name: ");
    	String newShipName = newShipInput.nextLine();
    	
    	// ensure new ship name does not already exist
    	for (Ship eachShip: shipList) {
    		if (eachShip.getShipName().equalsIgnoreCase(newShipName)) {
    			System.out.println("That ship is already in the system. Exiting to menu...");
    			return; // quits addShip() method processing
    		}
    	}
    	
    	// ensure ship name is at least one character
    	if (newShipName.length() < 1) {
    		System.out.println("Ship name must be at least one character. Exiting to menu...");
    		return; // quits addShip() method processing
    	}
    	
    	// prompt user for number of balcony rooms.
    	// entry must be numerical
    	// entry must not be negative
    	Boolean isNumber = false;
    	
    	int newRoomBalcony = 0;
    	
    	while (!isNumber) {
        	System.out.println("Enter number of balcony rooms: ");
        	if (newShipInput.hasNextInt()) {
        		newRoomBalcony = newShipInput.nextInt();
        		if (newRoomBalcony < 0) {
            		System.out.println("Number of rooms can't be negative. Exiting to menu...");
            		return; // quits addShip() method processing
            	}
        	} else {
        		System.out.println("Error: Please enter numeric values only.");
        		newShipInput.next();
        		continue;
        	}
        	isNumber = true;
    	}
        
    	// reset Boolean to false for next user input
        isNumber = false;
        
        // prompt user for number of ocean view rooms.
    	// entry must be numerical
    	// entry must not be negative
        int newRoomOceanView = 0;
        
        while(!isNumber) {
        	System.out.println("Enter number of ocean view rooms: ");
        	if (newShipInput.hasNextInt()) {
        		newRoomOceanView = newShipInput.nextInt();
        		if (newRoomOceanView < 0) {
            		System.out.println("Number of rooms can't be negative. Exiting to menu...");
            		return; // quits addShip() method processing
            	}
        	} else {
        		System.out.println("Error: Please enter numeric values only.");
        		newShipInput.next();
        		continue;
        	}
        	isNumber = true;
    	}
    	
        // reset Boolean to false for next user input
        isNumber = false;
        
        // prompt user for number of suite rooms.
    	// entry must be numerical
    	// entry must not be negative
        int newRoomSuite = 0;
        
        while(!isNumber) {
        	System.out.println("Enter number of suite rooms: ");
        	if (newShipInput.hasNextInt()) {
        		newRoomSuite = newShipInput.nextInt();
        		if (newRoomSuite < 0) {
            		System.out.println("Number of rooms can't be negative. Exiting to menu...");
            		return; // quits addShip() method processing
            	}
        	} else {
        		System.out.println("Error: Please enter numeric values only.");
        		newShipInput.next();
        		continue;
        	}
        	isNumber = true;
    	}
    	
        // reset Boolean to false for next user input
        isNumber = false;
        
        // prompt user for number of interior rooms.
    	// entry must be numerical
    	// entry must not be negative
        int newRoomInterior = 0;
        
        while(!isNumber) {
        	System.out.println("Enter number of interior rooms: ");
        	if (newShipInput.hasNextInt()) {
        		newRoomInterior = newShipInput.nextInt();
        		if (newRoomInterior < 0) {
            		System.out.println("Number of rooms can't be negative. Exiting to menu...");
            		return; // quits addShip() method processing
            	}
        	} else {
        		System.out.println("Error: Please enter numeric values only.");
        		newShipInput.next();
        		continue;
        	}
        	isNumber = true;
    	}
        
        int maxPassengers;
        maxPassengers = (newRoomInterior + newRoomSuite + newRoomBalcony + newRoomOceanView) * 2;
    	
    	// prompt user if ship is in service or not.
        // only Boolean values "true" or "false" are accepted.
        Boolean isBoolean = false;
        Boolean newInService = false;
        
        while(!isBoolean) {
        	System.out.println("Is ship in service? Enter \"true\" or \"false\"");
        	if (newShipInput.hasNextBoolean()) {
        		newInService = newShipInput.nextBoolean();
        	} else {
        		System.out.println("Error: Please enter only \"true\" or \"false\".");
        		newShipInput.next();
        		continue;
        	}
        	isBoolean = true;
        }
    
    	// Create new ship using user input and ship constructor
    	Ship newShip1 = new Ship(newShipName, newRoomBalcony, newRoomOceanView, newRoomSuite, newRoomInterior, maxPassengers, newInService);
        shipList.add(newShip1);
    }

    // Edit an existing ship   
    public static void editShip() {  

        // This method does not need to be completed      55555555555r
        System.out.println("The \"Edit Ship\" feature is not yet implemented.");

    }

    // Add a New Cruise
    public static void addCruise() {
    	
        // complete this method
    	Scanner newCruiseInput = new Scanner(System.in);
    	
    	// prompt user to enter cruise name
    	System.out.println("Enter the new cruise's name: ");
    	String newCruiseName = newCruiseInput.nextLine();
    	
    	// ensure cruise name is at least one character
    	if (newCruiseName.length() < 1) {
    		System.out.println("Cruise name must be at least one character. Exiting to menu...");
    		return; // quits addCruise() method processing
    	}
    	
    	// ensure new cruise name does not already exist
    	for (Cruise eachCruise: cruiseList) {
    		if (eachCruise.getCruiseName().equalsIgnoreCase(newCruiseName)) {
    			System.out.println("That cruise is already in the system. Exiting to menu...");
    			return; // quits addCruise() method processing
    		}
    	}
        
    	// prompt user to enter cruise ship name
    	System.out.println("Enter the cruise ship name: ");
    	String newCruiseShipName = newCruiseInput.nextLine();
    	
    	if (newCruiseShipName.length() < 1) {
    		System.out.println("Cruise ship name must be at least one character. Exiting to menu...");
    		return; // quits addCruise() method processing
    	}
    	
    	Boolean cruiseShipExists = false;
    	for (Ship eachShip: shipList) {
    		// ensure cruise ship name exists and is in service
    		if (eachShip.getShipName().equalsIgnoreCase(newCruiseShipName) && eachShip.getInService()) {
    			cruiseShipExists = true;
    		} 
    	}
    	
    	// if cruise ship is not in the system, or not in service, exit to menu
    	if (!cruiseShipExists) {
    		System.out.println("That ship is not in the system, or is not in service. Exiting to menu...");
    		return; // quits addCruise() method processing
    	}
    
    	// prompt user to enter departure port
    	System.out.println("Enter the cruise departure port: ");
    	String newCruiseDeparturePort = newCruiseInput.nextLine();
    	if (newCruiseDeparturePort.length() < 1) {
    		System.out.println("Departure port must be at least one character. Exiting to menu...");
    		return; // quits addCruise() method processing
    	}
    	
    	// prompt user to enter arrival port
    	System.out.println("Enter the cruise arrival port: ");
    	String newCruiseDestination = newCruiseInput.nextLine();
    	if (newCruiseDestination.length() < 1) {
    		System.out.println("Destination port must be at least one character. Exiting to menu...");
    		return; // quits addCruise() method processing
    	}
    	
    	// prompt user to enter return port
    	System.out.println("Enter the cruise return port: ");
    	String newCruiseReturnPort = newCruiseInput.nextLine();
    	if (newCruiseReturnPort.length() < 1) {
    		System.out.println("Return port must be at least one character. Exiting to menu...");
    		return; // 
    	}
    	
    	// All user input valid
    	// Create new cruise using user input and cruise constructor
    	Cruise newCruise1 = new Cruise(newCruiseName, newCruiseShipName, newCruiseDeparturePort, newCruiseDestination, newCruiseReturnPort);
    	cruiseList.add(newCruise1);
    }

    // Edit an existing cruise
    public static void editCruise() {

        // This method does not need to be completed
        System.out.println("The \"Edit Cruise\" feature is not yet implemented.");

    }

    // Add a New Passenger
    public static void addPassenger() {

        Scanner newPassengerInput = new Scanner(System.in);
        System.out.println("Enter the new passenger's name: ");
        String newPassengerName = newPassengerInput.nextLine();

        // ensure new passenger name does not already exist
        for (Passenger eachPassenger: passengerList) {
            if (eachPassenger.getPassengerName().equalsIgnoreCase(newPassengerName)) {
                System.out.println("That passenger is already in the system. Exiting to menu...");
                return; // quits addPassenger() method processing
            }
        }

        // get cruise name for passenger
        System.out.println("Enter cruise name: ");
        String newCruiseName = newPassengerInput.nextLine();

        // ensure cruise exists
        for (Cruise eachCruise: cruiseList) {
            if (eachCruise.getCruiseName().equalsIgnoreCase(newCruiseName)) {
                // cruise does exist
            } else {
                System.out.println("That cruise does not exist in the system. Exiting to menu...");
                return; // quits addPassenger() method processing
            }
        }

        // get room type
        System.out.println("Enter Room Type (BAL, OV, STE, or INT: ");
        String room = newPassengerInput.nextLine();
        // validate room type
        if ((room.equalsIgnoreCase("BAL")) || (room.equalsIgnoreCase("OV")) ||
                (room.equalsIgnoreCase("STE")) || (room.equalsIgnoreCase("INT"))) {
            // validation passed - add passenger
            Passenger newPassenger = new Passenger(newPassengerName, newCruiseName, room.toUpperCase());
            passengerList.add(newPassenger);
        } else {
            System.out.println("Invalid input. Exiting to menu...");
            return; // quits addPassenger() method processing
        }
    }

    // Edit an existing passenger
    public static void editPassenger() {

        // This method does not need to be completed
        System.out.println("The \"Edit Passenger\" feature is not yet implemented.");

    }

    // Method to check if input is a number
    public static boolean isANumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)) == false)
                return false;
        }
        return true;
    }

}
