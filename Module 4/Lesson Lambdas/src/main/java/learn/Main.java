package learn;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Address> addresses = getAddresses();

        List<Address> addressesByCity = filter(addresses, a -> a.getCity().equalsIgnoreCase("Roanoke"));
        List<Address> addressesByState = filter(addresses, a -> a.getState().equals("VA"));
        List<Address> addressesByPostalCode = filter(addresses, a -> a.getPostalCode().equals("55555"));
        List<Address> addressesByStateAndStreetName = filter(addresses, a -> a.getState().equals("HI")
                && a.getStreet().contains("Junction"));

    }

    static List<Address> filter(List<Address> source, Predicate<Address> criteria) {
        ArrayList<Address> result = new ArrayList<>();
        for (Address a : source) {
            if (criteria.test(a)) {
                result.add(a);
            }
        }
        return result;
    }

    // this lambda
/*
parameter, no type required. It's inferred.
|
| arrow separates parameters from method body
| |
| |       method body and implicit boolean return
| |       |
v v       v
a -> a.getCity().equalsIgnoreCase("Roanoke")
 */


    // is equivalent to
    static boolean inRoanoke(Address a) {
        return a.getCity().equalsIgnoreCase("Roanoke");
    }


    /*
    public void lambdaDeconstruction() {
    // 1. Named method
    Predicate<Address> criteria = this::inRoanoke;

    // 2. explicit parameter type and return
    criteria = (Address a) -> {
        return a.getCity().equalsIgnoreCase("Roanoke");
    };

    // 3. inferred parameter type, explicit return
    criteria = (a) -> {
        return a.getCity().equalsIgnoreCase("Roanoke");
    };

    // 4. no parameter parentheses, inferred parameter type, explicit return
        criteria = a -> {
            return a.getCity().equalsIgnoreCase("Roanoke");
        };

        // 5. inferred parameter type and return
        criteria = a -> a.getCity().equalsIgnoreCase("Roanoke");
    }

    boolean inRoanoke(Address a) {
        return a.getCity().equalsIgnoreCase("Roanoke");
    }

    Stream<Address> addressStream = getAddressStream();

// filter accepts Predicate<T>, which means:
// one parameter and a boolean return value.
addressStream.filter(a -> a.getCity().equals("Chicago"));

// forEach accepts Consumer<T>, which means:
// one parameter and no return value.
addressStream.forEach(a -> System.out.println(a));

// sorted accepts Comparator<T>, which means:
// two parameters and an int return value.
addressStream.sorted((a, b) -> a.getCity().compareTo(b.getCity()));

// map accepts Function<T, R>, which means:
// one parameter and an inferred return value.
addressStream.map(a -> a.getCity());

One Address parameter, returns a boolean:

// Named method
static boolean postalCodeStartsWith55555(Address address) {
    return address.getPostalCode().startsWith("55555");
}

public static void main(String[] args) {
    Stream<Address> addressStream = getAddressStream();

    // The method postalCodeStartsWith55555 accepts an Address
    // and returns a boolean.
    Predicate<Address> predicate = Main::postalCodeStartsWith55555;

    // Which is equivalent to this lambda.
    predicate = address -> address.getPostalCode().startsWith("55555");
}

One Address parameter, no return value:


  // Named method
static void logAddress(Address address) {
    Logger.getGlobal().log(Level.INFO, address.toString());
}

public static void main(String[] args) {
    Stream
 addressStream = getAddressStream();

    // The method logAddress accepts an Address
    // and doesn't return a value.
    Consumer
 consumer = Main::logAddress;

    // Which is equivalent to this lambda.
    consumer = address -> Logger.getGlobal().log(Level.INFO, address.toString());
}


No parameter, returns an Address:

// Named method
static Address makeEmptyAddress() {
    Address a = new Address();
    a.setName("");
    a.setStreet("");
    a.setCity("");
    a.setState("");
    a.setPostalCode("");
    return a;
}

public static void main(String[] args) {
    Stream<Address> addressStream = getAddressStream();

    // The method makeEmptyAddress doesn't accept an a parameter
    // and returns an Address.
    Supplier<Address> supplier = Main::makeEmptyAddress;

    // Which is equivalent to this lambda.
    supplier = () -> {
        Address a = new Address();
        a.setName("");
        a.setStreet("");
        a.setCity("");
        a.setState("");
        a.setPostalCode("");
        return a;
    };
}

One Address parameter, returns a String:

// Named method
static String extractName(Address address) {
    return address.getName();
}

public static void main(String[] args) {
    Stream<Address> addressStream = getAddressStream();

    // The method extractName accepts an Address
    // and returns a String.
    Function<Address, String> mapper = Main::extractName;

    // Which is equivalent to this lambda.
    mapper = address -> address.getName();
}

     */
}