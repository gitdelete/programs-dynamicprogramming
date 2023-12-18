package com.aman.dynamic;

import java.util.*;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {

        int[] arr =  { 10, 22, 9,1,2,3,4,5,6, 8, 33, 35,21, 23,24,25,50, 41, 60 };

        longestIncreasingSubsequence(arr, arr.length);
        System.out.println(lengthOfLIS(arr));
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
        System.out.println("Final ----  "+max);
    }

    static int lengthOfLIS(int[] nums) {
        // Binary search approach
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        // Initialize the answer list with the
        // first element of nums
        ans.add(nums[0]);

        for (int i = 1; i < n; i++) {
            if (nums[i] > ans.get(ans.size() - 1)) {
                // If the current number is greater
                // than the last element of the answer
                // list, it means we have found a
                // longer increasing subsequence.
                // Hence, we append the current number
                // to the answer list.
                ans.add(nums[i]);
                System.out.println("top -- "+nums[i]);
            } else {
                // If the current number is not
                // greater than the last element of
                // the answer list, we perform
                // a binary search to find the smallest
                // element in the answer list that
                // is greater than or equal to the
                // current number.

                // The binarySearch method returns
                // the index of the first element that is not less than
                // the current number.
                int low = Collections.binarySearch(ans, nums[i]);

                // We update the element at the
                // found position with the current number.
                // By doing this, we are maintaining
                // a sorted order in the answer list.
                System.out.println("low before -- "+low+"   "+nums[i]);
                if (low < 0) {
                    low = -(low + 1);
                }
                System.out.println("low after -- "+low+"   "+nums[i]);
                ans.set(low, nums[i]);
                System.out.println(ans);
            }
        }

        // The size of the answer list
        // represents the length of the
        // longest increasing subsequence.
        return ans.size();
    }


}
