package com.aman.dynamic;

import java.util.HashMap;
import java.util.Map;

public class TripletSumEquals_K {

    public static void main(String[] args) {

        int[] arr = { 1, 4, 45, 6, 10, 8 };
        int k=22;

        tripletSum(arr,k);

    }

    private static void tripletSum(int[] arr, int k) {

        int sumTwo=0;
        int sumThree=0;
        Map<Integer,Integer> map =  new HashMap<>();
        for(int i=0; i<arr.length; i++){
            map.put(arr[i],i);
            for(int j=1; j<arr.length; j++){
                sumTwo=arr[i]+arr[j];
                if(map.containsKey(k-sumTwo) && map.get(k-sumTwo)!= i && map.get(k-sumTwo)!= j && i!=j){  //i!=j every number taken once
                    sumThree=sumTwo+map.get(k-sumTwo);

                    System.out.println("i "+i);
                    System.out.println("j "+j);
                    System.out.println("map.get(k-sumTwo) "+map.get(k-sumTwo));
                    break;
                }
            }
        }

    }

}