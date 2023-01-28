package com.aman.dynamic;

public class LargestSubsetWithANDgreaterZero {

    public static void main(String[] args) {

        int[] arr = { 8,13,8,2,3 };
        largestSubset(arr);

        int[] arr1 = { 16,16 };
        largestSubset(arr1);

    }

    static void largestSubset(int[]  arr){

        int[] bitArray = new int[32];

        for (int i=0; i<arr.length; i++){

            int index= 31;
            System.out.println("-----------");
            while(arr[i] > 0){
                if((arr[i] & 1 ) == 1){
                    bitArray[index]++;
                    System.out.println("bit x "+bitArray[index]);
                }

                arr[i] = arr[i]/2;
                System.out.println("arr "+arr[i]);
                index--;
            }

        }

        int largestSubset= Integer.MIN_VALUE;
        for (int a=0; a<=31 ; a++){
            largestSubset = Integer.max(largestSubset, bitArray[a]);

        }

        System.out.println(largestSubset);
    }

}
