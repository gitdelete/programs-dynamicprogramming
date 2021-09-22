package com.aman.dynamic;

import java.util.Arrays;
import java.util.Collection;

public class JumpGameDP {

    public static void main(String[] args) {

        int[] arr = { 2, 2, 1, 2, 0, 9 };

       // minJumpsRecursion(arr,0, 0);       some problem with recursion, need to fix

        System.out.println(minJumps(arr));

        System.out.println(minJumpsLinearComplexity(arr));

    }

    private static int minJumpsLinearComplexity(int[] arr) {

        int maxReachable = arr[0];
        int steps = arr[0];
        int jumps = 1;

        if(arr.length<=1){
            return 1;
        }
        if(arr[0] == 0){
            return -1;
        }

        for(int i=1; i<arr.length ; i++){

            if (i == arr.length - 1)
                return jumps;
            maxReachable = Math.max(maxReachable,i+ arr[i]);

            steps--;

            if(i>=maxReachable)
                return -1;

            if(steps == 0)
            {
                jumps++;
                steps = maxReachable-i;
            }

        }
        return -1;
    }


    private static int minJumps(int[] arr) {

        if(arr.length<=1){
            return 1;
        }

        if (arr[0] == 0)
            return -1;

        int[] minJump = new int[arr.length];
        Arrays.fill(minJump,Integer.MAX_VALUE);
        minJump[0]=0;
        for(int i=1; i < arr.length; i++ ){
            for(int j=0; j<i; j++){
                if(arr[j]+j>=i && minJump[j]
                        != Integer.MAX_VALUE) {
                    minJump[i] = Math.min(minJump[i], minJump[j] + 1);
                }
            }
        }

//        Arrays.stream(minJump).forEach(System.out::println);

        return minJump[minJump.length-1];
    }

    private static boolean minJumpsRecursion(int[] arr, int i,int count) {

        if(i >= arr.length-1 ){
            System.out.println(count);
            return true;
        }

        if(arr[i] == 0 && arr.length-1 == i){
            System.out.println(count);
            return true;
        }

        if(arr[i] == 0 && i<arr.length-1){
            return false;
        }

        for(int x=i+1; x<=i+arr[i] && x<arr.length; x++) {
//            System.out.println(count);
            minJumpsRecursion(arr, x, ++count);
        }

        return false;
    }

}
