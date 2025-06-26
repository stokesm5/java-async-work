import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Arrays {
    public static void main(String[] args) {
        String[] names = new String[7];             //can hold 7 Strings, default value is null

        int[] grades = new int[16];                 //can hold 16 ints, default value is 0
        float[] monthlyIncome = new float[12];      //can hold 12 floats, default value is 0.0
        boolean[] yesNoAnswers = new boolean[50];   //can hold 50 booleans, default value is false
        Scanner[] scanners = new Scanner[3];        //can hold 3 Scanners, default value is null

        /*
        Run-time error - NegativeArraySizeException!
        int[] grades = new int[-12];

        //An array that stores zero values.
        int[] numbers = new int[0];
         */

        String[] planets = new String[8];

        //assign values to the first, second, and third planets
        //using index 0, 1, and 2.
        planets[0] = "Mercury";
        planets[1] = "Venus";
        planets[2] = "Mars";

        //read values by using an index
        //in this case, the element at index 5 is not set so its value
        //is the String default value 'null'
        System.out.println(planets[0]);  //Mercury
        System.out.println(planets[5]);  //null

        //Mars is not the third planet form the sun.
        //Fix it and complete the rest.
        planets[2] = "Earth";
        planets[3] = "Mars";
        planets[4] = "Jupiter";
        planets[5] = "Saturn";
        planets[6] = "Uranus";
        planets[7] = "Neptune";

        System.out.println(planets[2]);    //Earth
        System.out.println(planets[5]);    //Saturn

        String[] planetsLiteral = { "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        System.out.println(planetsLiteral[1]);  //Venus
        int[] evenNumbers = {2, 4, 6, 8, 10, 12, 14, 16};
        System.out.println(evenNumbers[4]);  //10

        /*
        int[] values = {1,2,3};
        Error: Array constants can only be used in initializers
        values = {4, 5, 6};
         */

        int[] values = {1, 2, 3};
        values = new int[] {4, 5, 6};

        String[] jupiterMoons = {"Io", "Ganymede"};
        jupiterMoons = new String[] {"Io", "Europa", "Ganymede", "Callisto"};

        System.out.printf("There are %s planets in the solar system.%n", planets.length);

        int[] oddNumbers = {1, 3, 5, 7};
        int oddCount = oddNumbers.length; //oddCount equals 4;

        String[] elements = { "Hydrogen", "Helium", "Lithium", "Beryllium"};

        //loop from front to back
        for (int index = 0; index < elements.length; index++){
            String elementName = elements[index];
            System.out.printf("The element at index %s is %s.%n", index, elementName);
        }

        //then back to front
        for (int index = elements.length - 1; index >= 0; index--){
            System.out.printf("The element at index %s is %s.%n", index, elements[index]);
        }

        values = new int[] {68, -72, -67, 82, -6, -49, 48, -36, 73, -27, 0, 3};

        int sum = 0;
        for (int i = 0; i < values.length; i++){
            sum = sum + values[i];
        }

        int average = sum / values.length;

        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);

        //String[] followed by another set of square brackets [].
        String[][] twoDimensionalArray;

        int[][] values2d = new int[10][12];

        /*
        //there are 45 null int[] in values
        int[][] values = new int[45][];

        //the array at index 5 is no longer null
        //it's now an int array with a capacity of 6.
        values[5] = new int[6];

        //the array at index 15 is no longer null
        //it's now an int array with a capacity of 22
        values[15] = new int[22];
         */

        String[][] threeOfAKind = {
                {"Strawberry", "Blueberry", "Gooseberry"},
                {"Red", "Yellow", "Blue"},
                {"Atlantic", "Pacific", "Indian"}
        };

        int[][][] valueCube = {
                {
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
                },
                {
                        {11,12,13},
                        {14,15,16},
                        {17,18,19}
                },
                {
                        {21,22,23},
                        {24,25,26},
                        {27,28,29}
                }
        };

        // Read from the second "row" and third "column";
        String element = threeOfAKind[1][2];

        System.out.println(element);            // Blue
        System.out.println(threeOfAKind[2][0]); // Atlantic

        // Replace the element in the third row, first column.
        threeOfAKind[2][0] = "Arctic";
        System.out.println(threeOfAKind[2][0]); // Arctic

        threeOfAKind[0][1] = "Cloudberry";

        System.out.println(threeOfAKind[0][0]); // Strawberry
        System.out.println(threeOfAKind[0][1]); // Cloudberry
        System.out.println(threeOfAKind[0][2]); // Gooseberry

        int value = valueCube[1][1][1];
        System.out.println(value);               // 15

        int[] oneDimension = valueCube[1][1];
        System.out.println(oneDimension[2]);     // 16

        int[][] twoDimensions = valueCube[1];
        System.out.println(twoDimensions[1][0]); // 14

        // Replace a sub-array.
        valueCube[2][2] = new int[] { 37, 38, 39 };
        System.out.println(valueCube[2][2][0]);  // 37

        for (int row = 0; row < threeOfAKind.length; row++){
            for (int col = 0; col < threeOfAKind[row].length; col ++){
                System.out.println(threeOfAKind[row][col]);
            }
        }

        /*
        int[][] values = new int[5][];
        values[0] = new int[] { 1, 2, 3 };
        values[2] = new int[] { 7, 8, 9 };

        // BAD CODE
        for (int row = 0; row < values.length; row++) {
            for (int col = 0; col < values[row].length; col++) {
                System.out.println(values[row][col]);
            }
        }
         */

        values2d[0] = new int[] { 1, 2, 3 };
        values2d[2] = new int[] { 7, 8, 9 };

        for (int row = 0; row < values.length; row++) {

            System.out.printf("Row %s: ", row);

            if (values2d[row] == null) {
                System.out.println("null");
                continue;
            }

            for (int col = 0; col < values2d[row].length; col++) {
                System.out.print(values2d[row][col] + " ");
            }

            System.out.println();
        }
    }
}