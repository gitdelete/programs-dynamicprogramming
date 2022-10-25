package com.aman.dynamic;

import java.util.ArrayList;
import java.util.List;

public class FindMissingNumberInArray{

    public static void main(String[] args) {

        int[] arr = {1,2,6,5,9,7,3,8};

        missingNumberUsingSum(arr);     //THis can go out of integer range , so XOR is better
        missingNumberUsingXOR(arr);
    }


    private static void missingNumberUsingSum(int[] arr) {

        int sum = (arr.length+1)*(arr.length+2)/2;

        for(int i = 0; i <arr.length; i++){
            sum=sum-arr[i];
        }

        System.out.println("Missing Number is "+sum);

    }

    // Similar numbers will cancel out as same bits results in 0 only missing number will be result;
    private static void missingNumberUsingXOR(int[] arr) {

        int arrayXOR=arr[0];
        for(int i = 1; i <arr.length; i++){
            arrayXOR=arrayXOR^arr[i];
        }
        System.out.println(arrayXOR);
        int exactXOR=1;
        for(int i = 2; i <=arr.length+1; i++){
            exactXOR=exactXOR^i;
        }
        System.out.println(exactXOR);
        System.out.println("Missing Number is "+(exactXOR^arrayXOR));

    }

}