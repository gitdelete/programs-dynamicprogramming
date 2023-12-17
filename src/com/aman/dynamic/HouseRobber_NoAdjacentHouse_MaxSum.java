package com.aman.dynamic;

public class HouseRobber_NoAdjacentHouse_MaxSum {

    public static int FindMaxSum(int arr[])
    {
        int prevTwo = 0;
        int prevOne = 0;
        int prev = 0;
        int sum=0;
        for(int i = 0 ; i<arr.length; i++){

            if(arr[i]+prevOne >= arr[i]+prevTwo){
                sum = arr[i]+prevOne;
            }else{
                sum = arr[i]+prevTwo;
            }
            // System.out.println("PrevTwo, PrevOne, Prev, Sum -- "+prevTwo+", "+prevOne+", "+prev+", "+ sum);
            prevTwo=prevOne;
            prevOne=prev;
            if(i != arr.length-1)
                prev = sum;
        }
        return Math.max(prev,sum);
    }

    public static void main(String[] args) {
        int[] arr = {5,5,10,100,10,7, 6};
        int result = FindMaxSum(arr);
        System.out.println(result);
    }
}
