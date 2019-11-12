package easy;

/*
    A bus has n stops numbered from 0 to n - 1 that form a circle. We know the distance between all
    pairs of neighboring stops where distance[i] is the distance between the stops number i and (i + 1) % n.

    The bus goes along both directions i.e. clockwise and counterclockwise.

    Return the shortest distance between the given start and destination stops.
 */
public class DistanceBetweenBusStops {

    public static void main(String... args) {

        int[] distance = {1, 2, 3, 4};
        DistanceBetweenBusStops distanceBetweenBusStops = new DistanceBetweenBusStops();
        System.out.println(distanceBetweenBusStops.distanceBetweenBusStops(distance, 0, 3));
    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {

        int n = distance.length;
        for (int i = 1; i < n; i++) distance[i] += distance[i-1];
        int s = Math.abs((start == 0 ? 0 : distance[start-1])
                - (destination == 0 ? 0 : distance[destination-1]));
        return Math.min(s, distance[n-1] - s);
    }

}
