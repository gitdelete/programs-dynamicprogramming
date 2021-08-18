package com.aman.dynamic.SlidingWindow.variable;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubarrayWithSumK {

    public static void main(String[] args) {
//cumulative sum    2  6  7   4  14   7  11 14 21 24 26 29 28
        int[] arr= {2, 4, 1, -3, 10, -7, 4, 3, 7, 3, 2, 3, -1};
        int k= 7;
        maxSubarray(arr, k);

    }

    public static void maxSubarray(int[] arr, int k){

        int sum=0;
        Map<Integer,Integer> sumMap = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            sum=sum+arr[i];
            sumMap.putIfAbsent(sum,i);
            if(sumMap.containsKey(sum-k)){
                System.out.println(sumMap.get(sum-k)+1+" "+ i);
            }
        }

    }
}
