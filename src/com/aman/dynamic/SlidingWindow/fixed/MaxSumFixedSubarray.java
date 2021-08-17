package com.aman.dynamic.SlidingWindow.fixed;

public class MaxSumFixedSubarray {

    /*
    *  Fixed window size of k =3
    *
    * */
    public static void main(String[] args) {

        int k = 3; // subarray fixed size
        int[] arr = {2,15,14,7,10,12,3,6,20,1,4,22};
        maxSumWindow(arr, k);

    }

    private static void maxSumWindow(int[] arr, int k) {
        int maxSum,sum=0;
        int j=0;
        for(int i= 0; i<k;i++){
            sum= sum + arr[i];
            j++;
        }
        maxSum=sum;
        for (int i=j; i<arr.length; i++){
            sum=sum-arr[i-k]+arr[i];
            System.out.println("sum "+sum);
            if(maxSum<sum){
                maxSum=sum;
            }
        }
        System.out.println(maxSum);
    }

}
