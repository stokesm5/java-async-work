//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Methods {
    /*
    public            static            String        readRequiredString(String       prompt      ) {
    [access modifier] [static modifier] [output type] [name]            ([param type] [param name]) {

        return           "value";
        [return keyword] [value that matches the data type of output]
    }
    */

    public static String readRequiredString(String prompt) {
        // code, code, code...
        return "value";
    }

    // DEFINE the method.
    // Always use "public static" for now.
    public static String createHello(String value) {
        // The expression after the `return` keyword is the output.
        // Its type must match the declared output type.
        return "Hello, " + value;
    }

    public static int minimum(int a, int b, int c) {
        int min = Math.min(a, b);
        // The return expression is an `int`, which matches the output data type.
        return Math.min(c, min);
    }

    // DEFINE
    public static char randomLetter() {
        String letters = "abcdefghijklmnopqrstuvwxyz";
        int index = (int) (Math.random() * 26);
        return letters.charAt(index);
    }

    // DEFINE
    // New keyword: `void`
    // Indicates that a method does NOT return a value.
    public static void repeatPrintln(String message, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(message);
        }
    }

    public static String createFullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    // DEFINE
    // Overloaded.
    // Signature: createFullName(String, String, String)
    public static String createFullName(String title, String firstName, String lastName) {
        // We can call the 2 argument version of createFullName
        // to re-use the logic.
        return title + " " + createFullName(firstName, lastName);
    }

    public static void main(String[] args) {

        /*
        String firstName       = readRequiredString("Enter your first name: "       );
        [type] [variable name] = [name]            ([expression matching param type]);
        */

        String firstName = readRequiredString("Enter your first name: ");

        String name = "Guillermo";
        // An argument can be a variable.
        // Output can be stored in a variable.
        String message = createHello(name);
        System.out.println(message); // Hello, Guillermo

        // An argument can be a literal.
        message = createHello("Avivah");
        System.out.println(message); // Hello, Avivah

        String honorary = "Dr. ";
        // An argument can be any expression of the correct data type.
        // Output can be used immediately as input to another method.
        // Here, it's used as an input for the `println` method.
        System.out.println(createHello(honorary + "Itch")); // Hello, Dr. Itch

        int result = minimum(1, 2, 3);
        System.out.println(result);                  // 1
        System.out.println(minimum(1000, 0, -1000)); // -1000
        System.out.println(minimum(255, 255, 255));  // 255

        char letter = randomLetter();
        System.out.println(letter);         // p (results vary because of randomness)
        System.out.println(randomLetter()); // k
        System.out.println(randomLetter()); // r

        System.out.println("Your garden:");
        repeatPrintln("hosta", 3);
        repeatPrintln("peony", 2);
        repeatPrintln("dandelion", 3);
        repeatPrintln("ghostflower", -9);

        // Pass 2 arguments.
        String fullName = createFullName("Powell", "Tatters");
        System.out.println(fullName);                                    // Powell Tatters

        String title = "Professor";
        firstName = "Leisha";
        String lastName = "Yendle";

        // Pass 3 arguments.
        fullName = createFullName(title, firstName, lastName);
        System.out.println(fullName);                                    // Professor Leisha Yendle

        // Pass 3 arguments.
        System.out.println(createFullName("Senator", "Ly", "De Lasci")); // Senator Ly De Lasci
    }
}