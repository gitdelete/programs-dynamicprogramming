package com.aman.dynamic;

import java.util.HashSet;
import java.util.Set;

public class LargestSumContiguousSubarrayUniqueElements {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 3, 4, 5, 3, 2, 1,5,6};

        findLargestSumSubarray(arr);
        
    }

    private static void findLargestSumSubarray(int[] arr) {

        int sum=0;
        int maxSum=0;
        Set<Integer> set = new HashSet<>();
        for(int i= 0,j=0 ; j<arr.length && i<arr.length-1;){

            if(!set.contains(arr[j])){
                sum= sum+ arr[j];
                maxSum=Math.max(sum,maxSum);
                set.add(arr[j]);
                j++;
            }else{
                sum= sum-arr[i];
                set.remove(arr[i]);
                i++;
            }


        }

        System.out.println(maxSum);

    }
}
