import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LocalDateExample {
    public static void main(String[] args) {

        LocalDate begin = LocalDate.of(2023, 10, 24);
        LocalDate end = begin.plusWeeks(3);
        // make up some booked dates
        List<LocalDate> notAvailable = getRandomDates(begin, end);
        // calculate the dates available
        for (LocalDate date : getAvailableDates(begin, end, notAvailable)) {
            System.out.printf("%s: %s%n", date.getDayOfWeek(), date);
        }

    }

    static List<LocalDate> getRandomDates(LocalDate start, LocalDate end) {
        Random rand = new Random();
        ArrayList<LocalDate> result = new ArrayList<>();
        for (LocalDate current = start; current.compareTo(end) <= 0; current = current.plusDays(1)) {
            if (rand.nextDouble() < 0.7) {
                result.add(current);
            }
        }
        return result;
    }

    // Given a start date, an end date, and a list of booked dates,
    // return a list of dates that are still available.
    static List<LocalDate> getAvailableDates(LocalDate start, LocalDate end, List<LocalDate> booked) {

        // LocalDates are reference types so we need to consider nulls.
        if (start == null || end == null) {
            throw new IllegalArgumentException("start and end are required.");
        }

        // start must come before, or be equal to, end.
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException("start must be before or equal to end.");
        }

        ArrayList<LocalDate> result = new ArrayList<>();

        // If booked is null, assume it means there are no booked dates.
        if (booked == null) {
            booked = new ArrayList<>();
        }

        for (LocalDate current = start; current.compareTo(end) <= 0; current = current.plusDays(1)) {
            if (!booked.contains(current)) {
                result.add(current);
            }
        }

        return result;
    }
}
