package medium;

/*
    Implement a MyCalendar class to store your events. A new event can be added if adding the event will not cause a double booking.

    Your class will have the method, book(int start, int end). Formally, this represents a booking on
    the half open interval [start, end), the range of real numbers x such that start <= x < end.

    A double booking happens when two events have some non-empty intersection
    (ie., there is some time that is common to both events.)

    For each call to the method MyCalendar.book,
    return true if the event can be added to the calendar successfully without causing a double booking.
    Otherwise, return false and do not add the event to the calendar.

    Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 */
public class MyCalendarI {

    private int n;
    private int[][] a = new int[1000][2];

    public static void main(String... args) {

        MyCalendarI myCalendarI = new MyCalendarI();
        System.out.println(myCalendarI.book(10, 20));
        System.out.println(myCalendarI.book(15, 25));
        System.out.println(myCalendarI.book(20, 30));
    }

    public boolean book(int start, int end) {

        int diff = end - start;

        for (int i = 0; i < n; i++)
            if (diff + a[i][1] - a[i][0] > Math.max(end - a[i][0], a[i][1] - start))
                return false;

        a[n][0] = start;
        a[n++][1] = end;
        return true;
    }

}
