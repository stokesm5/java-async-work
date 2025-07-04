package learn;
import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        /* The `E` is replaced by a type.
        ArrayList identifier = new ArrayList(); */
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        //ArrayList<NationalForest> forests = new ArrayList<NationalForest>();
        ArrayList<SoccerPlayer> goalKeepers = new ArrayList<SoccerPlayer>();

        /*ArrayList<SoccerPlayer> defense = new ArrayList<>(Arrays.asList(
                new SoccerPlayer(14, "Emily", "Sonnett", "DF"),
                new SoccerPlayer(19, "Crystal", "Dunn", "DF"),
                new SoccerPlayer(20, "Casey", "Short", "DF")
        ));*/
        goalKeepers.add(new SoccerPlayer(1, "Alyssa", "Naeher", "GK"));
        goalKeepers.add(new SoccerPlayer(18, "Ashlyn", "Harris", "GK"));
        goalKeepers.add(new SoccerPlayer(21, "Adrianna", "Franch", "GK"));

        ArrayList<SoccerPlayer> defense = new ArrayList<>();
        defense.add(new SoccerPlayer(14, "Emily", "Sonnett", "DF"));
        defense.add(new SoccerPlayer(19, "Crystal", "Dunn", "DF"));
        defense.add(new SoccerPlayer(20, "Casey", "Short", "DF"));

        ArrayList<SoccerPlayer> players = new ArrayList<>();
        players.addAll(goalKeepers);
        players.addAll(defense);

        defense.add(new SoccerPlayer(4, "Becky", "Sauerbrunn", "DF"));
        defense.add(new SoccerPlayer(5, "Kelley", "O'Hara", "DF"));
        defense.add(new SoccerPlayer(7, "Abby", "Dahlkemper", "DF"));
        defense.add(new SoccerPlayer(11, "Ali", "Krieger", "DF"));
        defense.add(new SoccerPlayer(12, "Tierna", "Davidson", "DF"));
        defense.add(new SoccerPlayer(14, "Emily", "Sonnett", "DF"));
        defense.add(new SoccerPlayer(19, "Crystal", "Dunn", "DF"));
        defense.add(new SoccerPlayer(20, "Casey", "Short", "DF"));

        SoccerPlayer fifth = defense.get(4);              // the fifth player is index 4
        System.out.println(fifth.getLastName());          // Davidson

        System.out.println(defense.get(6).getLastName()); // Dunn

        ArrayList<Integer> evens = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10));
        System.out.println(evens.get(0)); // 2
        System.out.println(evens.get(1)); // 4
        System.out.println(evens.get(2)); // 6

        /* Syntax
        for ([data type] [name] : [collection]) {
        }

        [data type] is the data type for an element in the [collection].
        [name] is a variable name that is valid only inside the code block.
        [collection] is an iterable collection like lists and arrays.
        */

        for (SoccerPlayer sp : defense) {
            System.out.printf("%s: %s %s, %s%n", sp.getNumber(), sp.getFirstName(), sp.getLastName(), sp.getPosition());
        }

        ArrayList<SoccerPlayer> forwards = new ArrayList<>();
        forwards.add(new SoccerPlayer(2, "Mallory", "Pugh", "FW"));
        forwards.add(new SoccerPlayer(10, "Carli", "Lloyd", "FW"));
        forwards.add(new SoccerPlayer(13, "Lynn", "Williams", "FW"));
        forwards.add(new SoccerPlayer(15, "Megan", "Rapinoe", "FW"));
        forwards.add(new SoccerPlayer(17, "Tobin", "Heath", "FW"));
        forwards.add(new SoccerPlayer(22, "Jessica", "McDonald", "FW"));
        forwards.add(new SoccerPlayer(23, "Christen", "Press", "FW"));

        System.out.println(forwards.size());

        SoccerPlayer removed = forwards.remove(3);
        System.out.printf("%s: %s, %s%n", removed.getNumber(), removed.getLastName(), removed.getPosition());
        removed = forwards.remove(3);
        System.out.printf("%s: %s, %s%n", removed.getNumber(), removed.getLastName(), removed.getPosition());
        removed = forwards.remove(3);
        System.out.printf("%s: %s, %s%n", removed.getNumber(), removed.getLastName(), removed.getPosition());

        System.out.println(forwards.size());
    }
}
