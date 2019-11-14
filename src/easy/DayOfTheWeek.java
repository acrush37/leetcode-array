package easy;

/*
    Given a date, return the corresponding day of the week for that date.

    The input is given as three integers representing the day, month and year respectively.

    Return the answer as one of the following values
    {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.
 */
public class DayOfTheWeek {

    public static void main(String... args) {

        DayOfTheWeek dayOfTheWeek = new DayOfTheWeek();
        System.out.println(dayOfTheWeek.dayOfTheWeek(31, 8, 2019));
    }

    public String dayOfTheWeek(int day, int month, int year) {

        int n = 4;
        int[] a = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        String[] b = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        for (int i = 1971; i < year; i++) n += i % 400 == 0 || i % 4 == 0 && i % 100 != 0 ? 366 : 365;
        for (int i = 0; i < month; i++) n += a[i];
        if (month >= 3 && (year % 400 == 0 || year % 4 == 0 && year % 100 != 0)) n++;
        return b[(n + day) % 7];
    }

}
