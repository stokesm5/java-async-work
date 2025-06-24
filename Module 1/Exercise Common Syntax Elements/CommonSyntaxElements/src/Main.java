/*
    - Must return how many '(' chars are in file.txt
    - Must return how many '[' chars are in file.txt
    - Must return how many '"" chars are in file.txt
 */

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) throws IOException {
        int numParentheses = 0;
        int numSqBracket = 0;
        int numDoubleQuotes = 0;
        String fileContent;

        try(BufferedReader br = new BufferedReader(new FileReader("src/file.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            fileContent = sb.toString();
        }

        for (int i = 0; i < fileContent.length(); i++) {
            char temp = fileContent.charAt(i);
            if(temp == '('){
                numParentheses++ ;
            } else if (temp == '[') {
                numSqBracket++;
            } else if (temp == '"') {
                numDoubleQuotes++;
            }
        }

        System.out.println("Parentheses: " + numParentheses);
        System.out.println("Square Brackets: " + numSqBracket);
        System.out.println("Double Quotes: " + numDoubleQuotes);
        //System.out.println(fileContent);
    }
}