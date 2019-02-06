import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;


public class Zork {

    private static HashMap<Integer, Boolean> myMap = new HashMap<>();
    private static int x = -1;

    public static void main(String[] args) {
        // welcomeMessage method
        welcomeMessage();

        /*
         * Ask the user to start*/
        promptUser();

        /*exitMessage method
         *   25% chance the user is followed by a ghost
         *   if followed let user know
         *   let user how many rooms left unvisited
         *   */
        exitMessage();
    }

    public static void currentPlace(int x) {
        switch (x) {
            case 0:
                break;
            case 1:
                room1();
                break;
            case 2:
                room2();
                break;
            case 3:
                room3();
                break;
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
            default:
                break;
        }
    }

    public static void welcomeMessage() {
        System.out.println("Welcome to Zork. We are on an adventure to explore the Castle of the Netherlands.");
        System.out.println("We will prompt you to answer and create your own journey!");
        System.out.println("Press Q to quit at any time");
    }

    public static void promptUser() {
        System.out.println("Would you like to continue? (Y/N) ");
        Scanner scanner1 = new Scanner(System.in);
        String y = scanner1.next();
        HashMap();
        if (y.equalsIgnoreCase("Y")) {
            x = 1;
            currentPlace(x);
        } else {
            x = 0;
            System.out.println("Exiting game. Goodbye");
            currentPlace(x);
        }
    }


    public static void room1() {
        myMap.put(1, true);
        System.out.println("You are in the Foyer");
        System.out.println("There is a dead scorpion in this room.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("You see a shadow in the midst of your eyes. Do you follow the shadow north? Press N to move or Q to quit: ");
        String answer = scanner.nextLine().toLowerCase();
        switch (answer) {
            case "n":
                System.out.println("Moving...");
                currentPlace(2);
                break;
            default:
                currentPlace(0);
                break;
        }
    }

    public static void room2() {
        myMap.put(2, true);
        System.out.println("Welcome to the Front room. You don't see the shadow but you do see a piano.");
        System.out.println("You move towards the piano and sit down.");
        System.out.println("You start playing on the piano when you hear creaking noises coming from other areas. ");
        System.out.println("You decide to explore. You can go South, East, or West");
        System.out.println("Where would you like to go? (S/E/W): ");
        Scanner input = new Scanner(System.in);
        String answer = input.next().toLowerCase();
        switch (answer){
            case "s":
                currentPlace(1);
                break;
            case "w":
                currentPlace(3);
                break;
            case "e":
                currentPlace(4);
                break;
            default:
                currentPlace(0);
                break;
        }
    }

    public static void room3() {
        myMap.put(3, true);
        System.out.println("Welcome to the Library. You scour around the library. You see books. ");
        System.out.println("You decide to pick up a book and you encounter a huge nest of spiders underneath. ");
        System.out.println("You are shocked and decide to leave. The directions you can go are North or East.");
        Scanner input = new Scanner(System.in);
        System.out.println("Where would you like to go? (N or E): ");
        String answer = input.next().toLowerCase();
        switch (answer){
            case "n":
                currentPlace(5);
                break;
            case "e":
                currentPlace(2);
                break;
            default:
                currentPlace(0);
                break;
        }
    }

    public static void room4() {
        myMap.put(4, true);
        String answer;
        System.out.println("You are now in the Kitchen.");
        System.out.println("This room contains bats!");

        System.out.println("Which direction would you like to go? West or North. (W/N): ");
        Scanner scanner = new Scanner(System.in);
        answer = scanner.nextLine().toLowerCase();
        switch (answer) {
            case "w":
                currentPlace(2);
                break;
            case "n":
                currentPlace(7);
                break;
            case "q":
                currentPlace(0);
                break;
            default:
                System.out.println("Please enter the correct direction");
                currentPlace(4);
                break;
        }
    }

    public static void room5() {
        myMap.put(5, true);
        System.out.println("Welcome to the Dining room. You see an empty table, knives, forks, and layers of dust covering everything.");
        System.out.println("You see a box. Do you want to open the box? (Y/N):");
        Scanner input = new Scanner(System.in);
        String answer = input.next();
        if (answer.equalsIgnoreCase("y")) {
            System.out.println("You open the box. It's empty. You decide you want to leave. ");
        } else {
            System.out.println("You didn't open the box, but nothing else caught your eye. You decide to leave.");
        }
        System.out.println("There is no other exit. Enter S to go back.");
        answer = input.next();
        currentPlace(3);
    }

    public static void room6() {
        myMap.put(6, true);
        Random rnd = new Random();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("You are in the Vault and there are 3 walking skeletons in this room.");
        int n = rnd.nextInt(4);
        if (!myMap.get(8)) {
            System.out.println("You can proceed ahead by going East: ");
            String choice = keyboard.nextLine();
            switch (n){
                case 0:
                    currentPlace(8);
                    break;
                default:
                    currentPlace(7);
                    break;
            }
            if (choice.equalsIgnoreCase("Q")){
                currentPlace(0);
            }
        } else {
            System.out.println("Would you like to go to the Parlor or the Secret room? Press 7 or 8, respectively: ");
            String choice = keyboard.next();
            switch (choice) {
                case ("7"):
                    x = 7;
                    currentPlace(x);
                    break;
                case ("8"):
                    x = 8;
                    currentPlace(x);
                    break;
                case ("q"):
                    currentPlace(x=0);
                default:
                    System.out.println("You entered the wrong number. Please choose between 7 and 8.");
                    x = 6;
                    currentPlace(x);
                    break;
            }
        }
    }


    public static void room7() {
        myMap.put(7, true);
        System.out.println("You are now in the Parlor.");
        System.out.println("There is a treasure chest in this room.");
        System.out.println("To leave the room, proceed West or South: (W/S)");
        Scanner keyboard = new Scanner(System.in);
        String proceed = keyboard.nextLine().toLowerCase();
        switch (proceed) {
            case "w":
                currentPlace(6);
                break;
            case "s":
                currentPlace(4);
                break;
            case "q":
                currentPlace(0);
                break;
        }
    }

    public static void room8() {
        myMap.put(8, true);
        System.out.println("You are in the secret room.");
        System.out.println("Yay! You've struck the piles of hidden gold!");
        System.out.println("To leave the room, proceed West: (W)");
        Scanner keyboard = new Scanner(System.in);
        String proceed = keyboard.nextLine().toLowerCase();
        switch (proceed){
            case "w":
                currentPlace(6);
                break;
            default:
                currentPlace(0);
                break;
        }
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
        System.out.println("You've explored " + count + " room(s) out of 8 total.");
    }
}
