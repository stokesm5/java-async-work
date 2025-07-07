package learn;

//required imports
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // "colors.txt" is a relative path.
        // The file will be created in the project root.
        File file = new File("colors.txt");
        try{
            if (file.createNewFile()) {
                System.out.println("colors.txt created. ");
            } else {
                System.out.println("colors.txt already exists.");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //try catch that needs to be closed in finally
        /*
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("colors.txt");
            writer.println("red");
            writer.println("blue");
            writer.println("yellow");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            // Always clean up!
            if (writer != null) {
                writer.close();
            }
        }
         */

        //automatically closes the stream when the statement is complete - USE TRY-WITH-RESOURCES

        try (PrintWriter writer = new PrintWriter("colors.txt")){
            writer.println("red");
            writer.println("blue");
            writer.println("yellow");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        //The second FileWriter constructor argument, true,
        // indicates this is an appending write.
        try (FileWriter fileWriter = new FileWriter("colors.txt", true);
                PrintWriter writer = new PrintWriter(fileWriter)) {
            writer.println("green");
            writer.println("orange");
            writer.println("purple");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("File contents: ");

        try (FileReader fileReader = new FileReader("colors.txt");
                BufferedReader reader = new BufferedReader(fileReader)) {

            //When there are no more lines, readLine() return null.
            for (String line = reader.readLine(); line != null; line = reader.readLine()){
                System.out.println(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        file = new File("colors.txt");
        boolean success = file.delete();
        if (success) {
            System.out.println("colors.txt was deleted.");
        } else {
            System.out.println("colors.txt was NOT deleted.");
        }
    }
}