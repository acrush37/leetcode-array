package easy;

/*
    In a list of songs, the i-th song has a duration of time[i] seconds.

    Return the number of pairs of songs for which their total duration in seconds is divisible by 60.

    Formally, we want the number of indices i < j with (time[i] + time[j]) % 60 == 0.
 */
public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

    public static void main(String... args) {

        int[] time = {30, 20, 150, 100, 40};
        PairsOfSongsWithTotalDurationsDivisibleBy60 pairsOfSongsWithTotalDurationsDivisibleBy60 = new PairsOfSongsWithTotalDurationsDivisibleBy60();
        System.out.println(pairsOfSongsWithTotalDurationsDivisibleBy60.numPairsDivisibleBy60(time));
    }

    public int numPairsDivisibleBy60(int[] time) {

        int[] f = new int[60];
        for (int x : time) f[x % 60]++;
        int result = (f[0] * (f[0] - 1)) >> 1;
        for (int i = 1; i < 30; i++) result += f[i] * f[60-i];
        return result + (f[30] * (f[30] - 1) >> 1);
    }

}
