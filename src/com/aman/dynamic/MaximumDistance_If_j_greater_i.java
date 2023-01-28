package com.aman.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumDistance_If_j_greater_i {


    public static void main(String[] args) {
        int arr[] = {10,200,20,40,50,100,245, 150,160,5};
        List<Integer> list = Arrays.asList(10,200,20,40,50,100,245, 150,160,5);

        System.out.println(maximumGap(list));

        System.out.println(maxIndexDiff(arr, arr.length));
    }

    public static int maximumGap(final List<Integer> list) {
        int size = list.size();

        List<Helper> helpers = new ArrayList<>(size);

        // Add each element into an helper array
        for (int i = 0; i < size; i++) {
            helpers.add(new Helper(list.get(i), i));
        }

        // Sort the helper array
        Collections.sort(helpers);

        for (int i = 0; i < size; i++) {
            System.out.print(helpers.get(i).value+","+helpers.get(i).index+"  ");
        }

        int[] rightMax = new int[size];
        int maxValue = Integer.MIN_VALUE;

        // Store the max value from the right to the left
        for (int i = size - 1; i >= 0; i--) {
            maxValue = Math.max(maxValue, helpers.get(i).index);
            rightMax[i] = maxValue;
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(rightMax[i]+"     ");
        }
        int maxDiff = Integer.MIN_VALUE;

        // Iterate over helper and check the diff value
        for (int i = 0; i < size; i++) {
            maxDiff = Math.max(maxDiff, rightMax[i] - helpers.get(i).index);
        }

        System.out.println();
        return maxDiff;
    }

    static class Helper implements Comparable<Helper> {
        public int value;
        public int index;

        public Helper(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Helper helper) {
            // Comparison on the value

            if (value < helper.value) {
                return -1;
            } else if (value == helper.value) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    // Another approach with O(n) time complexity

    static int max(int x, int y)
    {
        return x > y ? x : y;
    }

    static int min(int x, int y)
    {
        return x < y ? x : y;
    }

    /* For a given array arr[], returns the maximum j-i such that
       arr[j] > arr[i] */
    static int maxIndexDiff(int arr[], int n)
    {
        int maxDiff;
        int i, j;

        int RMax[] = new int[n];
        int LMin[] = new int[n];

        /* Construct LMin[] such that LMin[i] stores the minimum value
           from (arr[0], arr[1], ... arr[i]) */
        LMin[0] = arr[0];
        for (i = 1; i < n; ++i)
            LMin[i] = min(arr[i], LMin[i - 1]);

        /* Construct RMax[] such that RMax[j] stores the maximum value
           from (arr[j], arr[j+1], ..arr[n-1]) */
        RMax[n - 1] = arr[n - 1];
        for (j = n - 2; j >= 0; --j)
            RMax[j] = max(arr[j], RMax[j + 1]);

        /* Traverse both arrays from left to right to find optimum j - i
           This process is similar to merge() of MergeSort */
        i = 0;
        j = 0;
        maxDiff = -1;
        while (j < n && i < n) {
            if (LMin[i] <= RMax[j]) {
                maxDiff = max(maxDiff, j - i);
                j = j + 1;
            }
            else
                i = i + 1;
        }

        return maxDiff;
    }

}





