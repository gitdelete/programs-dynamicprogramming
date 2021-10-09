package com.aman.dynamic;

public class MinimumIncrementToMakeAllElementsEqual {

    public static void main(String[] args) {
        int[] arr= {3,4,6,6,3};
        minimumIncrementToMakeAllElementsEqual(arr,arr.length);
        int[] arr1= {3,4,6,6,3};
        minimumIncrementToMakeAllElementsEqualInLinearTime(arr1,arr1.length);
    }

    private static void minimumIncrementToMakeAllElementsEqualInLinearTime(int[] arr, int length) {

        int sum=0;
        for(int i =0; i<arr.length; i++){
           sum=sum+arr[i];
        }
        //find minimum element
        int min=arr[0];
        for(int i =1; i<arr.length; i++){
            if(arr[i]<min)
                min=arr[i];
        }
        long noOfOperations= sum - (arr.length*min);
        System.out.println(noOfOperations);
    }

    private static void minimumIncrementToMakeAllElementsEqual(int[] arr, int length) {

        long count = 0;
        boolean flag=true;
        while(flag) {
            if(!checkAllEqual(arr,length)) {
                int max = findMaxValue(arr, arr.length);
                incrementExceptMax(arr,max);
                count++;
            }else {
                flag=false;
            }
        }
        System.out.println(count);
//        for(int i =0; i<arr.length; i++){
//            System.out.println(arr[i]+" ");
//        }
    }

    private static void incrementExceptMax(int[] arr, int max) {
        for(int i =0; i<arr.length; i++){
            if(i!=max)
                arr[i]=arr[i]+1;
        }

    }

    private static boolean checkAllEqual(int[] arr, int length) {
        int first=arr[0];
        for(int i =1; i<length; i++){
            if(arr[i]!=first)
                return false;
        }
        return true;
    }

    private static int findMaxValue(int[] arr, int length) {

        int max=0;
        for(int i =1; i<length; i++){
            if(arr[i]>arr[max])
                max=i;
        }
        return max;
    }


}
