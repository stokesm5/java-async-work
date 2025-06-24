//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Variables{ //1. A class

    public static void main(String[] args) {  //2. The main method
        //we write our code here.  <--  //3. Our code
        /* declaration statement
        [type name] [variable name];
         */

        int linesOfCode;  //declaration statement

        /* assignment statement
        [variable name] = [value];
        */

        /*declaration with assignment
        [type name] [variable name] = [value];
         */

        int dogCount = 84;
        int catCount = 109;
        int petCount = dogCount + catCount;
        System.out.println(petCount); // 193

        int tacos = 12;
        System.out.println(tacos); //12

        //no need to add 'int' a second time.
        tacos = 29;
        System.out.println(tacos); //29

        tacos = 7;
        System.out.println(tacos); //7

        tacos = 17;
        int hotdogs = 23;
        int total = tacos + hotdogs;

        System.out.println(total); //40

        tacos = 22;
        System.out.println(total); //40, total didn't change
        System.out.println(tacos); //22, tacos changed

        total = tacos + hotdogs;  //reassign to update the total
        System.out.println(total);  //45

        byte b = 56;
        short s = 1024;
        int i = 314;
        long lng = -256;

        /*  The following assignment fail.
        b = 1024;  //value is too big for a byte
        s = 75000;  //too big for a short
        i = 3000000000  //too big for an int
        */

        float f = 3.14f;
        double d = 3.14;

        //whole number types
        b = 8;
        s = 16;
        i = 32; //int literal
        lng = 64L; //long literal

        //widening conversion (allowed)
        s = b;  //a byte fits in a short
        i = s;  //a short fits in an int
        lng = i;  //an int fits in a long
        lng = 32;  //'32' is an integer literal, it fits in a long

        //narrowing conversions (not allowed)
        // b = s;  //compiler error: cannot convert from short to byte
        // s = i;  //compiler error: cannot convert from int to short
        // i = lng; //compiler error: cannot convert from long to int

        //floating-point types
        f = 32.0f;  //float literal
        d = 64.0;  //double literal

        //widening conversion (allowed)
        d = f;  //a float fits in a double
        f = i;  //an int fits in a float
        d = lng;  //a long fits in a double

        //narrowing conversions (not allowed)
        // i = f;  //compiler error: cannot convert from float to int
        // f = d;  //compiler error: cannot convert from double to float
        // lng = d;  //compiler error: cannot convert from double to long

        float sum = 3.55f + 0.3f;  //sum is 3.85
        f = -0.33f;
        float result = sum + f;  //result is 3.52

        double value = 9.22 -1.1;  //value is 8.12
        d = 3.32;
        double dResult = value - d;  //result is 4.8

        int product = 20 * 4;  //product is 80
        int j = 3;
        int iResult = product * j;  //result is 240

        long lValue = 100L / 2L;  //value is 50
        lValue = 100L / 3L;  //value is 33 without decimals
            //whole number types 'int' and 'long' discard decimal results.
            //the value is truncated.
        long lLng = 11; //the literal '11' is an int but it fits in a long
        long lResult = lValue / lLng;  //result is 3

        int remainder = 100 % 3;  //remainder is 1
        remainder = 100 % 13;  //remainder is 9
        i = 3;
        iResult = remainder % iResult; //result is 0

        i = 25;
        iResult = 100 / (2 + 3) * i % (20 -3); //result is 7

        int burritos;  //Variable declaration is a statement.

        //We can't use the value of a declaration somewhere else
        //because a value isn't produced.
        //'int total = int burritos;' is a syntax error.

        System.out.println("hello world");  //println is a method call that doesn't produce a value
                                            //so it is a statement
                                            //Some methods_do_produce a value, but println does not.
        //We can't use println's value somewhere else because a value isn't produced.
        //'int letterCount = System.out.println("hello world");'
        //is a compiler error
        //"Type mismatch: cannot convert void to int"

        int teams = 8;  //assignt the value 8 to the variable teams
        int playersPerTeam = 12;  //assign the value 12 to the variable playerPerTeam
        int coachesPerTeam = 2;  //assign the value 2 to the variable coachesPerTeam
        int totalPeople = teams * (playersPerTeam + coachesPerTeam);  //assign the value of the expression to hte totalPeople

        int daysSinceAnAccident = 27;
        daysSinceAnAccident++;
        System.out.println(daysSinceAnAccident); //28

        int daysUntilHoliday = 64;
        daysUntilHoliday--;
        System.out.println(daysUntilHoliday); //63

        char a = 'a';
        char x = 'X';
        char one = '1'; //the character '1', not the value 1

        char singleQuote = '\''; //single quote;
        char newLine = '\n'; //the newline character (added by pressing Enter)n not the letter n
        char escape = '\\';  //the escape character must escape itself

        boolean isFast = true;
        boolean canFly = false;

        boolean bResult = true && false;  // result is false
        bResult = false && false;  //result is false
        bResult = false && true;  //result is false
        bResult = true && true;  //result is true

        bResult = true || false;  //result is true
        bResult = false || false; //result is false
        bResult = false || true; //result is true
        bResult = true || true;  //result is true

        bResult = !true;  //result is false
        bResult = !false;  //result is true

        boolean yes = true;
        boolean no = false;
        bResult = !(yes && no || (yes || true));  //result is false
        bResult = !yes && no || (yes || true);  //result is true

        int numberOne = 1;
        int negativeOne = -1;
        bResult = one == negativeOne; //result is false
        bResult = (one == 1);  // result is true, grouping with parentheses is optional

        char c = 'c';
        char z = 'z';
        bResult = c == z;  //result is false
        bResult = 'z' == z;  //result is true

        bResult = 1 < 25; //result is true;
        bResult = 1 <= 0; //result is false;
        bResult = 5 <= 5;  //result is true;
        bResult = 3.44 > 1.2;  //result is true;
        bResult = -5.55 >= -5.0;  //result is false;  
    }
}