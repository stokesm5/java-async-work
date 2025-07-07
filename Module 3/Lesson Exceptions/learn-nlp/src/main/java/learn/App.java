package learn;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {
    public static void main(String[] args) {
        /*
        // BAD CODE:
        String value = null;
        int[] numbers = new int[0];

        // 1. java.lang.NullPointerException
        int length = value.length();

        // 2. java.lang.ArrayIndexOutOfBoundsException
        int element = numbers[1];

        // 3. java.lang.NumberFormatException
        int n = Integer.parseInt(value);
        */

        String input = null;
        int value = 0;

        try{
            value = Integer.parseInt(input);
            System.out.println("Your value is: " + value); //doesn't execute
        } catch (NumberFormatException ex) {
            System.out.println("I acknowledge I may receive a NumberFormatException");
            System.out.println("It's okay. I have a plan.");
            System.out.println(ex);
        }

        input = "this is definitely not a number";
        try{
            value = Integer.parseInt(input);
            System.out.println("Your value is: " + value); //doesn't exectute
        } catch (NumberFormatException ex) {
            System.out.println("I acknowledge I may receive a NumberFormatException.");
            System.out.println("Hmmmm. Not sure to do if this fails...");
            System.out.println(ex);
        }

        input = "27";
        try{
            value = Integer.parseInt(input);
            System.out.println("Your value is: " + value); //doesn't exectute
        } catch (NumberFormatException ex) {
            System.out.println("I acknowledge I may receive a NumberFormatException.");
            System.out.println("Hmmmm. Not sure to do if this fails...");
            System.out.println(ex);
        }

        /* 'values' could be null or contain fewer than 6 elements.
        String[] values = getValues();
        String result = null;
        try {
            result = values[5];
            // 'result' could be null
            System.out.println(result.length());
        } catch (NullPointerException ex) {
            System.out.println("Either 'values' or 'result' is null.");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("There are fewer than 6 elements in the array.");
        }
         */

        // We don't know what we'll get here.
        /*
        String input = getInput();
        int result = 0;
        try {
            result = Integer.parseInt(input);
            System.out.println("Result is: " + result);
        } catch (NumberFormatException ex) {
            System.out.println("The input isn't a number.");
        } catch (RuntimeException ex) {
            System.out.println("This will trigger if we don't receive an NumberFormatException");
            System.out.println("but we do receive a RuntimeException.");
        } catch (Exception ex) {
            System.out.println("This will trigger if we don't receive an RuntimeException");
            System.out.println("but we do receive a Exception.");
        } catch (Throwable throwable) {
            System.out.println("This will trigger if we don't receive an Exception");
            System.out.println("but we do receive a Throwable.");
        }
         */

        /*
        // `values` could be null or contain fewer than 6 elements.
        String[] values = getValues();
        String result = null;
        try {
            result = values[5];
            // `result` could be null
            System.out.println(result.length());
        } catch (NullPointerException | IndexOutOfBoundsException ex) {
            System.out.println("Both the NullPointerException and IndexOutOfBoundsException are handled the same.");
            System.out.println(ex);
        }
         */
    }
}