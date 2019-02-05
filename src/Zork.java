import java.util.Scanner;
import java.util.ArrayList;

public class Zork {

    private static ArrayList<Boolean> roomsVisited = new ArrayList<>();
    // Initialized at false

    public static void main(String[]args){
        // welcomeMessage method
        // promptUser method
        // Ask the user what direction they want to go
        System.out.println("Which direction would you like to go? Press N/S/W/E or Q to quit.");
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();
        while(!input.equalsIgnoreCase("q")){
            // call room 7
            room7();
        }
        // moveUser method -- we may not need this
        // Move user to the desired room, tell them what room it is, and what's in the room, and what directions other exists are in
        // exitMessage method
        // 25% chance the user is followed by a ghost
        // if user followed, let them know
        // let user know how many rooms they've been in
    }

    public static void room1 (String input){
        System.out.println("You are in the foyer");
        System.out.println("There is a dead scorpion in this room");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if(answer.equalsIgnoreCase("y")){
            System.out.println("going to the next room...");
            room2(answer);
        }else{
            System.out.println("Staying in room 1");
        }
    }
    private static void room2(String input1) {
        System.out.println("Welcome to the Front room. You see a piano. You start playing on the piano when you hear creaking noises coming from other areas. ";
        System.out.println("You decide to explore. You can go South, East, West");
        System.out.println("Where would you like to go? (S/E/W): ");
        Scanner input = new Scanner(System.in);
        String answer = input.next();
        if (answer.equalsIgnoreCase("S")){
            room1(input);
        }
        if (answer.equalsIgnoreCase("W")){
            room3(input);
        }
        if (answer.equalsIgnoreCase("E")){
            room4(input);
        }
    }
    private static void room3(String input1) {
        System.out.println("Welcome to the Library. You scour around the library. You see books. ");
        System.out.println("You decide to pick up a book and you encounter a huge nest of spiders underneath. ");
        System.out.println("You are shocked and decide to leave. The directions you can go are North or East.");
        Scanner input = new Scanner(System.in);
        System.out.println("Where would you like to go? (N or E): ");
        String answer = input.next();
        if (answer.equalsIgnoreCase("n")){
            room5(input1);
        }
        if (answer.equalsIgnoreCase("e")){
            room2(input1);
        }
    }
    private static void room5(String input1){
        System.out.println("Welcome to the Dining room. You see an empty table, knives, forks, and layers of dust covering everything.");
        System.out.println("You see a box. Do you want to open the box? (Y/N):");
        Scanner input = new Scanner(System.in);
        String answer = input.next();
        if (answer.equalsIgnoreCase("y")){
            System.out.println("You open the box. It's empty. You decide you want to leave. There is no other doors.");
            System.out.println("Enter S to go back south. ");
            answer = input.next();
            room3(input1);
        } else {
            System.out.println("You didn't open the box, but nothing else caught your eye. You decide to leave.");
            System.out.println("There is no other doors. Enter S to go back south.");
            answer = input.next();
            room3(input1);
        }
    }
    public static void room7(){
        roomsVisited.add(true);
        System.out.println("You are in the parlor.");
        System.out.println("And there is a treasure chest in this room.");
        System.out.println("To leave the room, proceed West or South: (W/S)");
        Scanner keyboard = new Scanner(System.in);
        String proceed = keyboard.nextLine();

        if(proceed.equalsIgnoreCase("w")){
            // go to room 6
            room6();
        }

        if(proceed.equalsIgnoreCase("s")){
            // go to room 4
            room4();
        }
    }

    public static void room8(){
        roomsVisited.add(true);
        System.out.println("You are in the secret room.");
        System.out.println("Yay! You've struck the piles of hidden gold!");
        System.out.println("To leave the room, proceed West: (W)");
        Scanner keyboard = new Scanner(System.in);
        String proceed = keyboard.nextLine();

        if(proceed.equalsIgnoreCase("w")){
            // go to room 6
            room6();
        }
    }

    public static void welcomeMessage(){
        System.out.println("Welcome to Zork. We are on an adventure to explore the Castle of the Netherlands. " +
                "We start in the Foyer.");
    }

    public static void exitMessage(){
        // System.out.println("There's a chance you're being followed by a ghost...");
        int randomNum = (int)Math.random()*4;
        if(randomNum==0){
            System.out.println("Run! There's a ghost chasing you!");
        }else{
            System.out.println("No ghost on your tail.");
        }
        showVisitedRooms();

    }

    public static void showVisitedRooms(){
        int count = 0;
        for(boolean b:roomsVisited){
            if(b==false) { // never visited
                count++;
            }
        }
        System.out.println("There are " + count + " rooms that you haven't been to yet.");
    }
}
