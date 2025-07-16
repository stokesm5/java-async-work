//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}
/*
  // required imports
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
```

```java
// collections
List evenNumbers = List.of(2, 4, 6, 8, 10);
List players = getPlayers();
// arrays
String[] colors = {"red", "blue", "yellow", "green"};

// Create a Stream with collection.stream()
Stream numberStream = evenNumbers.stream();
Stream playerStream = players.stream();
// Create a Stream with Arrays.stream(array)
Stream colorStream = Arrays.stream(colors);
 */