package learn;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.HashSet;

public class App {

    public static void main(String[] args){
        // All keys should map to unique values.
        // The following are from our examples.
        HashMap<Integer, Character> numberToLetter = new HashMap<Integer, Character>();
        HashMap<Integer, Character> numberToAB = new HashMap<Integer, Character>();
        HashMap<Character, String> letterToFruit = new HashMap<Character, String>();
        HashMap<String, Login> emailToLogin = new HashMap<String, Login>();

        /* ALSO VALID
        HashMap<Integer, Character> numberToLetter = new HashMap<Integer, Character>();
        HashMap<Integer, Character> numberToAB = new HashMap<Integer, Character>();
        HashMap<Character, String> letterToFruit = new HashMap<Character, String>();
        HashMap<String, Login> emailToLogin = new HashMap<String, Login>();
         */

        // Using the jersey number as a key is dangerous. Depending on the players,
        // jersey numbers are likely to be duplicated.
        //HashMap<Integer, SoccerPlayer> jerseyNumberToPlayer = new HashMap<Integer, SoccerPlayer>();
        // Using the last name as a key is dangerous. Again, last name are seldom unique.
        //HashMap<String, SoccerPlayer> lastNameToPlayer = new HashMap<String, SoccerPlayer>();

        letterToFruit.put('A', "Apple");
        letterToFruit.put('B', "Banana");
        letterToFruit.put('C', "Cherry");
        letterToFruit.put('D', "Durian");

        Login one = new Login("cspacey0@myspace.com", "Carita", "Spacey");
        Login two = new Login("sbretherick1@va.gov", "Sammy", "Bretherick");
        emailToLogin.put(one.getEmailAddress(), one);
        emailToLogin.put(two.getEmailAddress(), two);

        String fruit = letterToFruit.get('B');
        System.out.println(fruit); // Banana

        fruit = letterToFruit.get('X');
        System.out.println(fruit); // null

        Login l = emailToLogin.get("cspacey0@myspace.com");
        System.out.println(l.getFirstName() + " " + l.getLastName()); // Carita Spacey

        l = emailToLogin.get("invalid@email.com");
        System.out.println(l); // null

        emailToLogin.put("zcripwell2@dot.gov", new Login("zcripwell2@dot.gov", "Zia", "Cripwell"));
        emailToLogin.put("spyatt3@marketwatch.com", new Login("spyatt3@marketwatch.com", "Sianna", "Pyatt"));
        emailToLogin.put("oranahan4@bing.com", new Login("oranahan4@bing.com", "Odelinda", "Ranahan"));

        System.out.println("Loop over values:");
        System.out.println("=====================");
        for (Login l : emailToLogin.values()) {
            System.out.printf("%s %s%n", l.getFirstName(), l.getLastName());
        }

        System.out.println("Loop over keySet:");
        System.out.println("=====================");
        for (String key : emailToLogin.keySet()) {
            Login l = emailToLogin.get(key);
            System.out.printf("%s %s%n", l.getFirstName(), l.getLastName());
        }

        System.out.println("Loop over entrySet:");
        System.out.println("=====================");
        for (Entry<String, Login> entry : emailToLogin.entrySet()) {
            System.out.printf("Key: %s, Value: %s %s%n",
                    entry.getKey(),
                    entry.getValue().getFirstName(),
                    entry.getValue().getLastName());
        }

        for (char key : letterToFruit.keySet()) {
            System.out.printf("Key: %s, Value: %s%n", key, letterToFruit.get(key));
        }

        letterToFruit.remove('B');
        letterToFruit.remove('C');
        letterToFruit.remove('X'); // no effect

        for (char key : letterToFruit.keySet()) {
            System.out.printf("Key: %s, Value: %s%n", key, letterToFruit.get(key));
        }

        System.out.println(emailToLogin.size());                            // 5
        System.out.println(emailToLogin.containsKey("zcripwell2@dot.gov")); // true
        System.out.println(emailToLogin.containsKey("invalid@email.com"));  // false

        emailToLogin.remove("zcripwell2@dot.gov");
        System.out.println(emailToLogin.size());                            // 4
        System.out.println(emailToLogin.containsKey("zcripwell2@dot.gov")); // false

        HashSet<Integer> uniqueNumbers = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            uniqueNumbers.add(1);
            uniqueNumbers.add(2);
            uniqueNumbers.add(3);
        }
        System.out.println("size: " + uniqueNumbers.size());

        for (int n : uniqueNumbers) {
            System.out.println(n);
        }

        HashSet<String> uniqueColors = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            uniqueColors.add("red");
            uniqueColors.add("blue");
            uniqueColors.add("yellow");
        }
        System.out.println("size: " + uniqueColors.size());

        for (String color : uniqueColors) {
            System.out.println(color);
        }

        HashSet<Login> uniqueLogins = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            uniqueLogins.add(new Login("cspacey0@myspace.com", "Carita", "Spacey"));
            uniqueLogins.add(new Login("sbretherick1@va.gov", "Sammy", "Bretherick"));
            uniqueLogins.add(new Login("zcripwell2@dot.gov", "Zia", "Cripwell"));
        }
        System.out.println("size: " + uniqueLogins.size());

        for (Login login : uniqueLogins) {
            System.out.println(login.getEmailAddress());
        }
    }
}
