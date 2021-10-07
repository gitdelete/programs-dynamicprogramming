package com.aman.dynamic;

import java.util.*;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {

        int[] arr =  { 10, 22, 9,1,2,3,4,5,6, 8, 33, 35,21, 23,24,25,50, 41, 60 };

        longestIncreasingSubsequence(arr, arr.length);

    }

    private static void longestIncreasingSubsequence(int[] arr, int length) {

        int[] list = new int[length];
        Arrays.fill(list,1);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && list[i] < list[j] + 1)
                    list[i] = list[j] + 1;
            }
        }
        int max=0;

        for (int i = 0; i < length; i++) {
            if (max < list[i]) {
                max = list[i];
                System.out.println(i+"  "+max);
            }
        }

    }


}
