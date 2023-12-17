package com.aman.dynamic;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;

public class DivideArrayIntoTwoWithMinimumSumDifference {

    public static void main(String[] args) {

        int[] arr1 = { 3, 1, 4, 2, 2, 1 };

        int totalSum1 = getTotalSum(arr1);
        int result1 = divideIntoTwo(arr1,-1, totalSum1, 0);
        System.out.println(result1);

        int[] arr2 = { 20,23,40,1};

        int totalSum2 = getTotalSum(arr2);
        int result2 = divideIntoTwo(arr2,-1, totalSum2, 0);
        System.out.println(result2);

        int[] arr3 = { 2, 3, 1, 4, 5 };
        System.out.println(findMin(arr3,arr3.length));

        int[] arr4 = { 20,23,40,1};
        System.out.println(findMin(arr4,arr4.length));
    }

    private static int getTotalSum(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        return sum;
    }

    private static int divideIntoTwo(int[] arr,int i,int totalSum,int calculatedSum) {

        if(i>=arr.length-1)
            return Math.abs((totalSum-calculatedSum)-calculatedSum);

        return Math.min(divideIntoTwo(arr,i+1,totalSum,calculatedSum+arr[i + 1]), divideIntoTwo(arr,i+1,totalSum,calculatedSum));

    }

    static int findMin(int arr[], int n)
    {
        // Calculate sum of all elements
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];

        // Create an array to store
        // results of subproblems
        int dp[][] = new int[n + 1][sum + 1];

        // Initialize first column as true.
        // 0 sum is possible  with all elements.
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        // Initialize top row, except dp[0][0],
        // as false. With 0 elements, no other
        // sum except 0 is possible
        for (int i = 1; i <= sum; i++)
            dp[0][i] = 0;
        int[] arr3 = { 2, 3, 1, 4, 5 };
        // Fill the partition table
        // in bottom up manner
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                // If i'th element is excluded
                dp[i][j] = dp[i - 1][j];

                // If i'th element is included
                if (arr[i - 1] <= j)
                    dp[i][j] |= dp[i - 1][j - arr[i - 1]];
            }
        }

        for (int i = 0; i <= n; i++) {
            System.out.println();
            for (int j = 0; j <= sum; j++) {
                System.out.print(" "+dp[i][j]+" ");
            }
        }

        // Initialize difference of two sums.
        int diff = Integer.MAX_VALUE;

        // Find the largest j such that dp[n][j]
        // is true where j loops from sum/2 to 0
        for (int j = sum / 2; j >= 0; j--) {
            // Find the
            if (dp[n][j] == 1) {
                diff = (sum - j) - j;       //(totalSum - calSum)-calSum
                break;
            }
        }
        System.out.println();
        return diff;
    }
}
