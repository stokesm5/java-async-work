//import java.time classes
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class Temporal {
    public void LocalDateAndPeriod() {
        // Use the class name, LocalDate, to access builder methods.
        LocalDate juneFirst = LocalDate.of(2020, 6, 1);  //numeric year, month, day
        LocalDate julyTwelfth = LocalDate.of(2020, Month.JULY, 12);  //month enum
        LocalDate today = LocalDate.now();  //current year, month, day

        System.out.println(juneFirst);
        System.out.println(julyTwelfth);
        System.out.println(today);

        System.out.println(julyTwelfth.getYear());  //2020
        System.out.println(julyTwelfth.getMonth());  //JULY (Month enum)
        System.out.println(julyTwelfth.getMonthValue());  //7
        System.out.println(julyTwelfth.getDayOfMonth());  //12
        System.out.println(julyTwelfth.getDayOfYear());  //194
        System.out.println(julyTwelfth.getDayOfWeek());  //SUNDAY (DayOfWeek enum)

        System.out.println(today);  //today
        LocalDate weekFromToday = today.plusWeeks(1);  //new instance
        System.out.println(today);  //today
        System.out.println(weekFromToday);  //a week from now

        System.out.println(today); //today
        System.out.println(today.plusYears(12));  //12 years from now
        System.out.println(today.plusMonths(100));  //100 months from now
        System.out.println(today.plusWeeks(27));  //27 weeks from now
        System.out.println(today.minusDays(10000));  //10000 days from now

        System.out.println(today.minusYears(12));  //12 years ago
        System.out.println(today.minusMonths(100));  //100 months ago
        System.out.println(today.minusWeeks(27));  //27 weeks ago
        System.out.println(today.minusDays(10000));  //10000 days ago

        //Negative arguments
        System.out.println(today.plusDays(-100)); //100 days ago
        System.out.println(today.minusDays(-100));  //100 days from now

        LocalDate start = LocalDate.of(2011, 4, 22);
        LocalDate end = LocalDate.of(2025, 11, 7);

        // Approaches A and B are equivalent.  Choose one.
        // A. instance method
        Period difference = start.until(end);
        // B. static method
        difference = Period.between(start, end);

        System.out.println(difference.getYears());  //14
        System.out.println(difference.getMonths());  //6
        System.out.println(difference.getDays());  //16

        // Add and subtract using a Period.
        System.out.println(today.plus(difference));  //todays date plus difference
        System.out.println(today.minus(difference));  //todays date minus difference

        Random rand = new Random();
        int year = LocalDate.now().getYear();
        int dayOfMonth = rand.nextInt(Month.AUGUST.maxLength()) + 1;

        LocalDate day = LocalDate.of(year, Month.AUGUST, dayOfMonth);
        LocalDate stop = day.plusWeeks(2);

        for (; day.compareTo(stop) < 0; day = day.plusDays(1)) {
            if (day.getDayOfWeek() != DayOfWeek.SATURDAY && day.getDayOfWeek() != DayOfWeek.SUNDAY) {
                System.out.printf("%s: %s%n", day.getDayOfWeek(), day);
            }
        }
    }

    public void LocalTime() {
        LocalTime elevenFifteenAM = LocalTime.of(11, 15);  //AM
        LocalTime elevenFifteenPM = LocalTime.of(23, 15);  //PM
        LocalTime now = LocalTime.now();

        System.out.println(elevenFifteenAM);  //11:15
        System.out.println(elevenFifteenPM);  //23:15
        System.out.println(now);  //current time

        System.out.println(now);  //current time
        System.out.println(now.plusHours(2));  //two hours from now
        System.out.println(now.plusMinutes(64));  //64 mintues from now
        System.out.println(now.plusSeconds(35));  //35 seconds from now;
        System.out.println(now.plusNanos(100123));  //that many nano seconds from now

        // adding 48 hours wraps around to the original time
        System.out.println(now.plusHours(48));  //current time

        LocalTime one = LocalTime.of(3, 45, 32);
        LocalTime two = LocalTime.of(21, 12, 5);

        Duration difference = Duration.between(one, two);

        //Taken together, the 'Part' methods add up to a duration.

        //Taken together, the 'Part' methods add up to a duration.
        System.out.println(difference.toHoursPart());  //17
        System.out.println(difference.toMinutesPart());  //26
        System.out.println(difference.toSecondsPart());  //33
        System.out.println(difference.toNanosPart()); //0

        //Non-part methods give unit totals.
        System.out.println(difference.toHours());  //17
        System.out.println(difference.toMinutes());  //1046
        System.out.println(difference.toSeconds());  //62793

        final LocalTime noon = LocalTime.of(12, 0);
        final LocalTime quittingTime = LocalTime.of(17, 30);

        Duration appointmentDuration = Duration.ofMinutes(20);
        LocalTime start = LocalTime.of(7, 30);
        LocalTime end = start.plus(appointmentDuration);

        System.out.println("Appointments before lunch:");
        while (!end.isAfter(noon)) {
            System.out.printf("%s - %s%n", start, end);
            start = end;
            end = start.plus(appointmentDuration);
        }

        start = LocalTime.of(13, 0);  // 1:00PM
        end = start.plus(appointmentDuration);

        System.out.println("Appointments after lunch:");
        while (!end.isAfter(quittingTime)) {
            System.out.printf("%s - %s%n", start, end);
            start = end;
            end = start.plus(appointmentDuration);
        }
    }

    public void FormattingAndParsing(){
        LocalDateTime now = LocalDateTime.of(2020, 7, 8, 17, 15);

        DateTimeFormatter fourDigitYear = DateTimeFormatter.ofPattern("yyyy");
        DateTimeFormatter twoDigitYear = DateTimeFormatter.ofPattern("yy");

        DateTimeFormatter oneDigitMonth = DateTimeFormatter.ofPattern("M");
        DateTimeFormatter twoDigitMonth = DateTimeFormatter.ofPattern("MM");
        DateTimeFormatter monthAbbr = DateTimeFormatter.ofPattern("MMM");
        DateTimeFormatter monthName = DateTimeFormatter.ofPattern("MMMM");

        System.out.println(now.format(fourDigitYear)); // 2020
        System.out.println(now.format(twoDigitYear));  // 20
        System.out.println(now.format(oneDigitMonth)); // 7
        System.out.println(now.format(twoDigitMonth)); // 07
        System.out.println(now.format(monthAbbr));     // Jul
        System.out.println(now.format(monthName));     // July

        DateTimeFormatter oneDigitDayOfMonth = DateTimeFormatter.ofPattern("d");
        DateTimeFormatter twoDigitDayOfMonth = DateTimeFormatter.ofPattern("dd");

        DateTimeFormatter dayOfYear = DateTimeFormatter.ofPattern("D");
        DateTimeFormatter dayOfWeekAbbr = DateTimeFormatter.ofPattern("eee");
        DateTimeFormatter dayOfWeekName = DateTimeFormatter.ofPattern("eeee");

        System.out.println(now.format(oneDigitDayOfMonth)); // 8
        System.out.println(now.format(twoDigitDayOfMonth)); // 08
        System.out.println(now.format(dayOfYear));          // 190
        System.out.println(now.format(dayOfWeekAbbr));      // Wed
        System.out.println(now.format(dayOfWeekName));      // Wednesday

        DateTimeFormatter twelveHourOneDigit = DateTimeFormatter.ofPattern("h");
        DateTimeFormatter twelveHourTwoDigit = DateTimeFormatter.ofPattern("hh");
        DateTimeFormatter twentyFourHour = DateTimeFormatter.ofPattern("kk");
        DateTimeFormatter twelveHourTwoDigitAMPM = DateTimeFormatter.ofPattern("hha");

        DateTimeFormatter minutesTwoDigits = DateTimeFormatter.ofPattern("mm");
        DateTimeFormatter secondsTwoDigits = DateTimeFormatter.ofPattern("ss");

        System.out.println(now.format(twelveHourOneDigit));     // 5
        System.out.println(now.format(twelveHourTwoDigit));     // 05
        System.out.println(now.format(twentyFourHour));         // 17
        System.out.println(now.format(twelveHourTwoDigitAMPM)); // 05PM
        System.out.println(now.format(minutesTwoDigits));       // 15
        System.out.println(now.format(secondsTwoDigits));       // 00

        DateTimeFormatter usDate = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter usTime = DateTimeFormatter.ofPattern("h:mma");
        DateTimeFormatter usDateTime = DateTimeFormatter.ofPattern("MM/dd/yyyy h:mma");
        DateTimeFormatter monthAbbrDate = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

        DateTimeFormatter dotDate = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        DateTimeFormatter formalDate = DateTimeFormatter.ofPattern("d MMMM, yyyy");
        // The first two M's have meaning. The third M, surrounded
        // by single quotes is embedded directly in the output.
        DateTimeFormatter withLiteral = DateTimeFormatter.ofPattern("yy.MM'M'.dd");

        System.out.println(now.format(usDate));        // 07/08/2020
        System.out.println(now.format(usTime));        // 5:15PM
        System.out.println(now.format(usDateTime));    // 07/08/2020 5:15PM
        System.out.println(now.format(monthAbbrDate)); // 08-Jul-2020
        System.out.println(now.format(dotDate));       // 2020.07.08
        System.out.println(now.format(formalDate));    // 8 July, 2020
        System.out.println(now.format(withLiteral));   // 20.07M.08

        Scanner console = new Scanner(System.in);

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("h:mma");

        System.out.print("Enter a date in month/day/year format:");
        LocalDate date = LocalDate.parse(console.nextLine(), dateFormat);
        System.out.println(date); // default format

        System.out.print("Enter a time in twelve hour:minute format:");
        LocalTime time = LocalTime.parse(console.nextLine(), timeFormat);
        System.out.println(time); // default format
    }
}