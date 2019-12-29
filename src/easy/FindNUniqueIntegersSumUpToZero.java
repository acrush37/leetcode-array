package easy;

/*
    Given an integer n, return any array containing n unique integers such that they add up to 0.
 */
public class FindNUniqueIntegersSumUpToZero {

    public static void main(String... args) {

        FindNUniqueIntegersSumUpToZero findNUniqueIntegersSumUpToZero = new FindNUniqueIntegersSumUpToZero();
        System.out.println(findNUniqueIntegersSumUpToZero.sumZero(5));
    }

    public int[] sumZero(int n) {

        int s = 0;
        int[] result = new int[n];
        for (int i = 1; i < n; i++) s += result[i] = i;
        result[0]= -s;
        return result;
    }

}
