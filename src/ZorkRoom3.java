import java.util.Scanner;

public class ZorkRoom3 {
    public static void main(String[] args){
        System.out.println("Welcome to Zork. We are on an adventure to explore the Castle of the Netherlands. We start in the Foyer. We encounter a dead");
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
}
