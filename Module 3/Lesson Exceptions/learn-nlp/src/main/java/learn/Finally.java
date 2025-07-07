package learn;

import learn.exception.NegativeValueException;
import learn.exception.RequiredStringException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Scanner;

public class Finally {
    public void Example(){
        FileReader reader = null;

        try {
            reader = new FileReader("data.txt");
            System.out.println(reader.read());
        } catch (FileNotFoundException ex) {
            System.out.println("Couldn't find the file.");
        }  catch (IOException ex) {
            System.out.println("Couldn't read from the file.");
        } finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException ex){
                    System.out.println("Couldn't close the file.");
                }
            }
        }
    }

    /*public Number readNumber(String prompt) {
        Scanner console = new Scanner(System.in);
        NumberFormat formatter = NumberFormat.getInstance();

        System.out.print(prompt);

        // BAD CODE: Compile-time error
        // "Unhandled exception type ParseException"
        //return formatter.parse(console.nextLine());
        try{
            return formatter.parse(console.nextLine());
        } catch (ParseException ex) { //acknowledged and handled
            return null;
        }
    }*/

    public Number readNumber(String prompt) throws ParseException { //acknowledged, not handled
        Scanner console = new Scanner(System.in);
        NumberFormat formatter = NumberFormat.getInstance();

        System.out.print(prompt);
        return formatter.parse(console.nextLine());
    }

    public void getMinAndMax() throws ParseException{ //acknowledged, not handled
        Number min = readNumber("Enter a minimum: ");
        Number max = readNumber("Enter a maximum: ");
    }

    //custom checked exception
    public int addPositiveValues(int a, int b) throws NegativeValueException { // 4. Acknowledge the checked exception.
        // 1. Detect problem.
        if (a < 0 || b < 0) {
            // 2. Instantiate exception.
            NegativeValueException ex = new NegativeValueException("Arguments may not be negative.");
            // 3. Throw. Immediately terminates the method. No value is returned.
            throw ex;
        }
        return a + b;
    }

    //custom unchecked exception
    public String addDr(String name) {
        // 1. Detect problem.
        if (name == null || name.isEmpty()) {
            // 2. Instantiate exception.
            RequiredStringException ex = new RequiredStringException("`name` is required.");
            // 3. Throw. Immediately terminates the method. No value is returned.
            throw ex;
        }
        return "Dr. " + name;
    }

    //Unchecked exception from the standard library
    public String repeat(String value, int times) {

        // 1. Detect problem.
        if (times < 0) {
            // 2. Instantiate exception.
            IllegalArgumentException ex = new IllegalArgumentException("`times` cannot be negative.");
            // 3. Throw. Immediately terminates the method. No value is returned.
            throw ex;
        }

        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < times; i++) {
            buffer.append(value);
        }
        return buffer.toString();
    }
}

