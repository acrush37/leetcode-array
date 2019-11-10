package easy;

/*
    The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
    such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

        F(0) = 0,   F(1) = 1
        F(N) = F(N - 1) + F(N - 2), for N > 1.

    Given N, calculate F(N).
 */
public class FibonacciNumber {

    public static void main(String... args) {

        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        System.out.println(fibonacciNumber.fib(4));
    }

    public int fib(int N) {

        if (N == 0) return 0;
        int[] f = new int[N+1];
        f[1] = 1;
        for (int i = 2; i <= N; i++) f[i] = f[i-1] + f[i-2];
        return f[N];
    }

}
