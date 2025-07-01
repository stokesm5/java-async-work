//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {
    public static void main(String[] args) {
        // 1. instantiation
        NationalForest one = new NationalForest("Dixie", "Utah", 123);
        //2. set a 'public' field
        //one.name = "Allegheny";
        //one.location = "Pennsylvania";
        //one.acres = 513655;

        //NationalForest two = new NationalForest("Angeles", "California", 661565);
        NationalForest two = new NationalForest("Angeles", 661565);
        //two.name = "Angeles";

        //NationalForest three = new NationalForest("Angelina", "Texas", 1554140);
        NationalForest three = new NationalForest("Angelina");
        //three.name = "Angelina";

        NationalForest four = new NationalForest();

        String format = "name: %s, location: %s, acres: %s%n";
        // 3. read each 'public' field
        // each object's fields have different values````````````
        //System.out.printf(format, one.name, one.location, one.acres);
        //System.out.printf(format, two.name, two. location, two.acres);
        //System.out.printf(format, three.name, three.location, three.acres);
        //System.out.printf(format, four.name, four.location, four.acres);

        System.out.println(one.toLine());
        System.out.println(two.toLine());
        System.out.println(three.toLine());
        System.out.println(four.toLine());

        //individual fields and calculations
        System.out.println("Forest Name: " + one.getName());
        System.out.println("Location: " + one.getLocation());
        System.out.println("Acres: " + one.getAcres());
        System.out.println("Square km: " + one.getSquareKilometers());

        //all together
        System.out.println(one.toLine());

        //acres is wrong, fix it
        one.setAcres(1885655);
        System.out.println("Fixed ---");
        System.out.println("Acres: " + one.getAcres());
        System.out.println("Square km: " + one.getSquareKilometers());`
    }
}