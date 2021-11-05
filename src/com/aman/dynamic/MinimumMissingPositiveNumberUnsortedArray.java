package com.aman.dynamic;

public class MinimumMissingPositiveNumberUnsortedArray {

    public static void main(String[] args) {
        int[] arr = {5,10,7,6,2,1,8,9,11,4};

        findMissingPositiveInteger(arr);  // Linear time Complexity
    }

    private static void findMissingPositiveInteger(int[] arr) {

        for(int i=0; i<arr.length; i++){

            int x= Math.abs(arr[i]);
            if(x-1 <arr.length && arr[x-1]>0){
                arr[x-1]=-arr[x-1];
            }
        }

        for (int i=0; i<arr.length; i++){
            if(arr[i]>0){
                System.out.println(i+1);
            }
        }

    }
}
