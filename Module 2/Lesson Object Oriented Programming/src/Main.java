import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        /*public class Scanners {
            public static void main(String[] args) {
                Scanner console = new Scanner(System.in);
                String result;
                do {
                    System.out.print("Enter a value: ");
                    result = console.nextLine();
                    System.out.println("You entered: " + result);
                } while (!result.equals("exit"));
            }
        }*/

        Scanner one = new Scanner("one\ntwo\nthree\nfour");
        Scanner two = new Scanner("red\nyellow\bblue\ngreen");

        String result;

        while (one.hasNext()) {
            result = one.next();
            System.out.println(result);
        }

        while (two.hasNext()){
            result = two.next();
            System.out.println(result);
        }

        one = new Scanner("one!two!three!four");
        two = new Scanner("one!two!three!four");
        two.useDelimiter("!");

        System.out.println("one's delimiter: " + one.delimiter());
        while (one.hasNext()) {
            result = one.next();
            System.out.println(result);
        }

        System.out.println("two's delimiter: " + two.delimiter());
        while (two.hasNext()) {
            result = two.next();
            System.out.println(result);
        }

    }
}