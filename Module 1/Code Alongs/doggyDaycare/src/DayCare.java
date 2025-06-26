import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class DayCare {
    /*
        on start up we should be able to input the number of daycare spots available for the day
        we should be able to check a dog into our daycare
        we should be able to check a dog out of our daycare
        we should be able to view all dogs in our care
        we should be able to exit our program
     */
    //variables
    static Scanner console = new Scanner(System.in);
    static String[] daycareSpaces;
    static int capacity;


    public static void main(String[] args) {
        startUp();
    }

    //methods
    public static void startUp(){
        System.out.println("Welcome to the Doggy Daycare");
        System.out.println("Please enter the number of spaces available for today: ");

        capacity = Integer.parseInt(console.nextLine());
        daycareSpaces = new String[capacity];
        menu();
    }

    public static void menu(){
        boolean exit = false;
        do {
            System.out.println("What would you like to do?");
            System.out.println("1. Check a dog into daycare");
            System.out.println("2. Check a dog out of daycare");
            System.out.println("3. View all dogs in our care");
            System.out.println("4. Exit");
            System.out.println("Please enter your choice: ");
            int choice = Integer.parseInt(console.nextLine());

            switch (choice){
                case 1:
                    checkInDog();
                    break;
                case 2:
                    checkOutDog();
                    break;
                case 3:
                    viewAllDogs();
                    break;
                case 4:
                    System.out.println("\n Thank you for vising the doggy daycare have a nice day!");
                    exit = true;
                    break;
                default:
                    System.out.println("That is not a valid choice, please try again.");
            }
        } while(!exit);
    }

    //check in a dog
    public static void checkInDog(){
        System.out.println("Who is the good dog visiting us today?: ");
        String dogName = console.nextLine();

        for(int i = 0; i < daycareSpaces.length; i++){
            if(daycareSpaces[i] == null){
                daycareSpaces[i] = dogName;
                System.out.println("\n" + dogName + " had been checked into the daycare!  See you this evening for pickup!");
                return;
            }
        }
        System.out.println("\nSorry, there is no space available today.  We are fully booked!");
    }

    //check out a dog3
    public static void checkOutDog(){
        System.out.print("\n What is the name of the dog you are picked up?: ");
        String dogName = console.nextLine();

        for(int i = 0; i < daycareSpaces.length; i++){
            if(daycareSpaces[i] != null && daycareSpaces[i].equalsIgnoreCase(dogName)){
                daycareSpaces[i] = null;
                System.out.println("\n" + dogName + " has successfully been picked up by their owner.");
                return;
            }
        }
        System.out.println("\nSorry, we can't find your dog. I don't think its checked into our day care today.");
    }

    //view all dogs in our care
    public static void viewAllDogs(){
        System.out.println("\nCurrent Dogs in our Care: ");
        int availableSpaces = 0;
        for(int i = 0; i < daycareSpaces.length; i++){
            if(daycareSpaces[i] != null) {
                System.out.println(daycareSpaces[i]);
            } else{
                availableSpaces++;
            }
        }
        System.out.println("Available Spaces: " + availableSpaces);
    }
}