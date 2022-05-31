package com.aman.dynamic;

public class FabonacciRecursion {

    private static int count;
    private static int maxCount = 10;

    public static void main(String[] args) {

        fabonacci(0,1);
    }

    private static void fabonacci(int m, int n) {
            System.out.println(n);
            count++;
            if(count <= maxCount)
                fabonacci(n,m+n);
    }

    /* OTHER WAY
    static int fib(int n)
    {
    if (n <= 1)
       return n;
    return fib(n-1) + fib(n-2);
    }
    */

}
