package com.aman.dynamic;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicatesInArray {

    public static void main(String[] args) {
        int[] arr = {1,1,2,5,3,6,7,4,7,8,9,9};

        findDuplicateUsingMap(arr);  //Takes extra O(n) space
        findDuplicateUsingAbsolute(arr); // Takes only O(1) space
    }
    private static void findDuplicateUsingMap(int[] arr) {
        System.out.println("Using Map !!");
        Map<Integer,Integer> hashMap = new HashMap();

        for (int i= 0; i<arr.length; i++){
            if(hashMap.containsKey(arr[i])) {
                hashMap.put(arr[i],hashMap.get(arr[i])+1);
                System.out.println("Duplicate found " + arr[i]);
            }
            else
                hashMap.put(arr[i],1);
        }

    }

    private static void findDuplicateUsingAbsolute(int[] arr) {
        System.out.println("Using Absolute !!");
        for (int i= 0; i<arr.length; i++){

            int x= Math.abs(arr[i]);
            if(arr[x] >= 0){
                arr[x]=-arr[x];
            }
            else {
                System.out.println("Duplicate found " + x);
            }
        }


    }

}
