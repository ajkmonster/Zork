import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;


public class Zork {

    private static HashMap<Integer, Boolean> myMap = new HashMap<>();
    private static int currentPlace = -1;

    public static void main(String[] args) {
        // welcomeMessage method
        welcomeMessage();

        /*
         * Ask the user to start*/
        currentPlace = promptUser();
        switch (currentPlace) {
            case 0:
                break;
            case 1:
                currentPlace = room1();
//                break;
            case 2:
                currentPlace = room2();
//                break;
            case 3:
                currentPlace = room3();
//                break;
            case 4:
                room4();
                break;
            case 5:
                room5();
                break;
            case 6:
                room6();
                break;
            case 7:
                room7();
                break;
            case 8:
                room8();
                break;
        }

        /*exitMessage method
         *   25% chance the user is followed by a ghost
         *   if followed let user know
         *   let user how many rooms left unvisited
         *   */
        exitMessage();
    }


    public static void welcomeMessage() {
        System.out.println("Welcome to Zork. We are on an adventure to explore the Castle of the Netherlands.");
        System.out.println("We will prompt you to answer and create your own journey!");
        System.out.println("Press Q to quit at any time");
    }

    public static int promptUser() {
        System.out.println("Would you like to continue? (Y/N) ");
        Scanner scanner1 = new Scanner(System.in);
        String y = scanner1.next();
        HashMap();
        if (y.equalsIgnoreCase("Y")) {
            return 1;
        } else {
            return 0;
//            System.out.println("Exiting game. Goodbye");
        }
    }


    public static int room1() {
        myMap.put(1, true);
        System.out.println("You are in the foyer");
        System.out.println("There is a dead scorpion in this room.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("You see a shadow in the midst of your eyes. Do you follow the shadow north? Press N to move: ");
        String answer = scanner.nextLine().toLowerCase();
        switch (answer) {
            case "n":
                System.out.println("Moving...");
                currentPlace = 2;
            default:
                currentPlace = 0;
        }
        return currentPlace;
    }

    public static int room2() {
        myMap.put(2, true);
        System.out.println("Welcome to the Front room. You don't see the shadow but you do see a piano.");
        System.out.println("You move towards the piano and sit down.");
        System.out.println("You start playing on the piano when you hear creaking noises coming from other areas. ");
        System.out.println("You decide to explore. You can go South, East, or West");
        System.out.println("Where would you like to go? (S/E/W): ");
        Scanner input = new Scanner(System.in);
        String answer = input.next();
        if (answer.equalsIgnoreCase("S")) {
            currentPlace = 1;
        }
        if (answer.equalsIgnoreCase("W")) {
            currentPlace = 3;
        }
        if (answer.equalsIgnoreCase("E")) {
            currentPlace = 4;
        } else {
            currentPlace = 0;
        }
        return currentPlace;
    }

    public static int room3() {
        myMap.put(3, true);
        System.out.println("Welcome to the Library. You scour around the library. You see books. ");
        System.out.println("You decide to pick up a book and you encounter a huge nest of spiders underneath. ");
        System.out.println("You are shocked and decide to leave. The directions you can go are North or East.");
        Scanner input = new Scanner(System.in);
        System.out.println("Where would you like to go? (N or E): ");
        String answer = input.next();
        if (answer.equalsIgnoreCase("n")) {
            currentPlace = 5;
        }
        if (answer.equalsIgnoreCase("e")) {
            currentPlace = 2;
        } else {
            currentPlace = 0;
        }
        return currentPlace;
    }

    public static int room4() {
        myMap.put(4, true);
        String answer;
        System.out.println("You are currently in the kitchen");
        System.out.println("This room contains bats");

        System.out.println("Which direction would you like to go in west or north. (W or N): ");
        Scanner scanner = new Scanner(System.in);
        answer = scanner.nextLine().toLowerCase();
        switch (answer) {
            case "w":
                currentPlace = 2;
            case "n":
                currentPlace = 7;
            case "q":
                currentPlace = 0;
            default:
                System.out.println("Please enter the correct direction");
                currentPlace = 4;
        }
        return currentPlace;
    }

    public static int room5() {
        myMap.put(5, true);
        System.out.println("Welcome to the Dining room. You see an empty table, knives, forks, and layers of dust covering everything.");
        System.out.println("You see a box. Do you want to open the box? (Y/N):");
        Scanner input = new Scanner(System.in);
        String answer = input.next();
        if (answer.equalsIgnoreCase("y")) {
            System.out.println("You open the box. It's empty. You decide you want to leave. There is no other doors.");
            System.out.println("Enter S to go back south. ");
            answer = input.next();
            currentPlace = 3;
        } else {
            System.out.println("You didn't open the box, but nothing else caught your eye. You decide to leave.");
            System.out.println("There is no other doors. Enter S to go back south.");
            answer = input.next();
            currentPlace = 3;
        }
        return currentPlace;
    }

    public static int room6() {
        myMap.put(6, true);
        Random rnd = new Random();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("You are in the Vault and there are 3 walking skeletons in this room");
        int n = rnd.nextInt(4);
        if (!myMap.get(8)) {
            System.out.println("You can proceed ahead by going east: ");
            String choice = keyboard.nextLine();
            if (n == 0) {
                currentPlace = 8;
            } else if (choice.equalsIgnoreCase("q")) {
                currentPlace = 0;
            } else {
                currentPlace = 7;
            }
        } else {
            System.out.println("Would you like to go to the parlor or the secret room? Press 7 or 8, respectively: ");
            int choice = keyboard.nextInt();
            switch (choice) {
                case 7:
                    currentPlace = 7;
                case 8:
                    currentPlace = 8;
                default:
                    System.out.println("You entered the wrong number. Please choose between 7 and 8.");
                    currentPlace = 6;
            }
        }
        return currentPlace;
    }


    public static int room7() {
        myMap.put(7, true);
        System.out.println("You are in the parlor.");
        System.out.println("And there is a treasure chest in this room.");
        System.out.println("To leave the room, proceed West or South: (W/S)");
        Scanner keyboard = new Scanner(System.in);
        String proceed = keyboard.nextLine();

        if (proceed.equalsIgnoreCase("w")) {
            //return 6;
            currentPlace = 6;
        }

        if (proceed.equalsIgnoreCase("s")) {
            //return 4;
            currentPlace = 4;
        } else {
            currentPlace = 0;
        }
        return currentPlace;
    }

    public static int room8() {
        myMap.put(8, true);
        System.out.println("You are in the secret room.");
        System.out.println("Yay! You've struck the piles of hidden gold!");
        System.out.println("To leave the room, proceed West: (W)");
        Scanner keyboard = new Scanner(System.in);
        String proceed = keyboard.nextLine();

        if (proceed.equalsIgnoreCase("w")) {
            currentPlace = 6;
        } else {
            currentPlace = 0;
        }
        return currentPlace;
    }


    public static void exitMessage() {
        // System.out.println("There's a chance you're being followed by a ghost...");
        Random rnd = new Random();
        int randomNum = rnd.nextInt(4);
        if (randomNum == 0) {
            System.out.println("Run! There's a ghost chasing you!");
        }
        VisitedRooms();
    }


    public static void HashMap() {
        myMap.put(1, false);
        myMap.put(2, false);
        myMap.put(3, false);
        myMap.put(4, false);
        myMap.put(5, false);
        myMap.put(6, false);
        myMap.put(7, false);
        myMap.put(8, false);
    }

    public static void VisitedRooms() {
        int count = 0;
        for (int i = 1; i <= myMap.size(); i++) {
            if (myMap.get(i)) {
                count += 1;
            }
        }
        System.out.println("There are " + count + " rooms that you have been to.");
    }
}
