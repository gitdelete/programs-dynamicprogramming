package com.aman.dynamic;

/*
*   Ugly numbers are divided by only prime numbers 2,3 or 5. If any other prime no is factor of
*   number , that number is not ugly
*   ex: 1,2,3,4,5,6,8,9,10,12,15,16.......
*
*   "14" is not ugly as it is divided by 7 as well which is prime
*
* */

// Find nth ugly number
// it can also be solved in java using treeset easily
public class UglyNumbers {

    static int count= 6;
    public static void main(String[] args) {

       int n= 12;

        int ugly = findNthUglyNumber(n);
        System.out.print(ugly);
    }


    private static int findNthUglyNumber(int n) {

        int i2 = 0, i3 = 0, i5 = 0;
        int num2 =2 , num3=3 , num5=5;
        int uglyNumber = 1;
        int[] ugly = new int[n+3];
        ugly[0]=1;
        for(int i= 1; i<n; i++) {

            uglyNumber = Math.min(Math.min(num2, num3), num5);
            ugly[i] = uglyNumber;
            if(uglyNumber == num2) {
                i2=i2+1;
                num2 = ugly[i2] * 2;
            }
            if(uglyNumber == num3) {
                i3=i3+1;
                num3 = ugly[i3] * 3;
            }
            if(uglyNumber == num5) {
                i5=i5+1;
                num5 = ugly[i5] * 5;
            }


        }
        return uglyNumber;
    }
}
