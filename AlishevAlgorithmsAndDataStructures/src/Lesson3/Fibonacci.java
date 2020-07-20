package Lesson3;

import java.util.Arrays;

/**
 * @author BR
 */
public class Fibonacci {
    public static void main(String[] args) {
        int n = 100;
        long[] mem = new long[n + 1];

        Arrays.fill(mem, -1);

        System.out.println(fibNaive(n, mem));
    }

    // O(2^n)
    private static long fibNaive(int n, long[] mem) {
        if (mem[n] != -1)
            return mem[n];

        if (n <= 1)
            return n;

        long result = fibNaive(n - 1, mem) + fibNaive(n - 2, mem);
        mem[n] = result;
        return result;
    }

    // O(n)
    private static long fibEffective(int n) {
        // O(n)
        long[] arr = new long[n + 1];

        arr[0] = 0;
        arr[1] = 1;

        // n = 2 => 1
        // n = 3 => 2
        // n = 4 => 3

        // O(n + n) => O(2n) => O(n)

        for (int i = 2; i <= n; i++)
            arr[i] = arr[i - 1] + arr[i - 2];

        return arr[n];
    }
}

// 1.000.000x
// x
// 1000y
// (1/1.000.000) * 2^1000 * y

// O(n) + O(1) + O(1) + O(n) + O(1) = O(2n) + O(3) = O(2n + 3) = On