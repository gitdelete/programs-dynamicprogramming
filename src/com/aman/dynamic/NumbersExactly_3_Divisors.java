package com.aman.dynamic;

import java.util.HashSet;
import java.util.Set;

public class NumbersExactly_3_Divisors {

    static void numbersWith3Divisors(int N)
    {
        System.out.println("Numbers with 3 divisors : ");

        for (int i = 2; i * i <= N; i++) {

            // Check prime
            if (isPrime(i)) {
                if (i * i <= N) {
                    System.out.print(i * i + " ");
                }
            }
        }
    }

    // Check if a number is prime or not
    public static boolean isPrime(int N)
    {

        for (int i = 2; i * i <= N; i++) {
            if (N % i == 0)
                return false;
        }
        return true;
    }

    // Driver code
    public static void main(String[] args)
    {
        int N = 122;

        // Function call
        numbersWith3Divisors(N);
    }

}
