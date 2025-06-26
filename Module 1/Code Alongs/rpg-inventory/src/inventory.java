import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class inventory {
    public static void main(String[] args) {
        // show intro
        System.out.println("Welcome to RPG Inventory");

        String[] backpack = new String[8];
        Scanner console = new Scanner(System.in);
        // loop menu
        String input;
        do{
            System.out.println("Main Menu");
            System.out.println("1. Add an Item");
            System.out.println("2. Display Backpack");
            System.out.println("3. Exit");

            System.out.print("Select [1-3]:");
            input = console.nextLine();

            if(input.equals("1")){
                addItem(console, backpack);
            }else if(input.equals("2")){
                displayBackpack(backpack);
            }else if(input.equals("3")) {
                System.out.println("Goodbye");
            }else {
                System.out.println("I don't understand that option.");
            }
        }while(!input.equals("3"));

    }

    static void addItem(Scanner console, String[] backpack){
        System.out.println("Add an Item");
        System.out.println("Slot #: ");
        int slot = Integer.parseInt(console.nextLine()) - 1;
        if(slot < 0 || slot >= backpack.length){
            return;
        }
        System.out.print("Item: ");
        String item = console.nextLine();
        backpack[slot] = item;
    }

    static void displayBackpack(String[] backpack){
        System.out.println("Items");
        for(int i = 0; i < backpack.length; i++){
            System.out.printf("Slots #%s: %s%n",
                    i + 1, backpack[i] == null ? "[empty]" : backpack[i]);
        }
    }
}