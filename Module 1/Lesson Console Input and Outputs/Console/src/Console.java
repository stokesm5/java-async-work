//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;  //  <-- import the fully qualified name

public class Console {
    public static void main(String[] args) {
        //java.util.Scanner console = new java.util.Scanner(System.in); //1

        Scanner console = new Scanner(System.in);  // <-- use the simple name

        System.out.println("Enter your name:");
        String name = console.nextLine();
        System.out.println("Your name is: " + name);

        //change all question output to 'print'
        System.out.print("Enter a grocery item: ");
        String grocery = console.nextLine();

        System.out.print("What does it cost?: ");
        double cost = Double.parseDouble(console.nextLine());

        System.out.print("How many are available?: ");
        int inventory = Integer.parseInt(console.nextLine());

        System.out.print("Is it taxable? [true/false]: ");
        boolean isTaxable = Boolean.parseBoolean(console.nextLine());

        //report -- a mix of 'print' and 'println' to get the desired result
        //no string concatenation
        System.out.println();
        System.out.println("====================");
        System.out.print(grocery);
        System.out.print(": $");
        System.out.println(cost);
        System.out.print("Current inventory: ");
        System.out.println(inventory);
        System.out.print("Taxable: ");
        System.out.println(isTaxable);

        //The format string: "%s has %s %s and can jump %s inches vertically."
        // other arguments replace each '%s' in order
        System.out.printf("%s has %s %s and can jump %s inches vertically.", "Nomi", 3, "dogs", 37.68);

        double stockPrice = 87.6549513216;
        System.out.printf("%s %n", stockPrice);  //default string terminated with a newline
        System.out.printf("%f %n", stockPrice);  //formate as floating point
        System.out.printf("%.2f %n", stockPrice);  //floating point with a max of 2 digits after the decimal
        System.out.printf("%05.1f %n", stockPrice);  //floating point with 1 digit after the decimal...
                                                     //a minimum of 5 printed characters, padded by 0s

        //Example: %-20s
        // % : start placeholder
        // - : left justified
        // 20: a minimum of 20 printed characters
        // s : general string format
        String rowFormat = "| %-20s  | %-15s  | %6s | %n";

        //header
        System.out.println("Beetle Families");
        System.out.println("-".repeat(51));
        System.out.printf(rowFormat, "Common Name", "Latin Name", "Rating");
        System.out.println("-".repeat(51));

        //rows
        System.out.printf(rowFormat, "Carrion Beetles", "Silphidae", 9.7);
        System.out.printf(rowFormat, "Darkling Beetles", "Tenebrionidea", 10.0);
        System.out.printf(rowFormat, "Fireflies", "Lampyridae", 9.98);
        System.out.printf(rowFormat, "Fungus Weevils", "Anthribidae", 9.45);
        System.out.printf(rowFormat, "Ladybugs", "Coccinellidae", 9.62);

        //footer
        System.out.println("-".repeat(51));

        String firstName = "Husein";
        String lastName = "Vaan";

        //fullName becomes "Husein Vaan"
        String fullName = String.format("%s %s", firstName, lastName);

        //title becomes "Name: Husein Vaan, Occupation: Game Developer
        String title = String.format("Name: %s, Occupation: %s", fullName, "Game Developer");
    }
}