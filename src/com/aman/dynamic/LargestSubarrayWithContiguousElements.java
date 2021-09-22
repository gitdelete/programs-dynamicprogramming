package com.aman.dynamic;

public class LargestSubarrayWithContiguousElements {

    public static void main(String[] args) {
        int[] arr = {1,43,46,44,45,78,79,80,2,3,7,5,6,4,10};

        findLengthOfLargestSubarray(arr);
    }

    private static void findLengthOfLargestSubarray(int[] arr) {

        int maxLength = 1;

        int sum=0;
        for(int i=0; i<arr.length-1; i++){

            int min=arr[i], max=arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);

                if ((max - min) == (j - i)) {
                    maxLength = Math.max(maxLength, (max - min + 1));
                    System.out.println(min+ " "+max);
                }
            }

        }

        System.out.println(maxLength);

    }

}
