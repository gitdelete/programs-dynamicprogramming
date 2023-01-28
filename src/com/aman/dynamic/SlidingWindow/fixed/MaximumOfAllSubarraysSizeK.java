package com.aman.dynamic.SlidingWindow.fixed;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumOfAllSubarraysSizeK
{
    public static void main(String[] args) {
        int k = 3; // subarray fixed size
        int[] arr = {2,15,14,2,3,4,5,7,10,12,3,6,20,1,4,22};
        maxSumWindow(arr, k);

        System.out.println("");
        int k2 =4;
        int[] arr2 = {16,14,15, 2,18,4,5,7,10,12,3,6,20,1,4,22};
        maxSumWindow(arr2, k2);
    }

    private static void maxSumWindow(int[] arr, int k) {
        int max=0;
        int i=0;
        Deque<Integer>  maxList = new LinkedList<>();

        for (i=0; i<k; i++) {
                while (!maxList.isEmpty() && arr[maxList.peekLast()] <= arr[i]) {
                    maxList.removeLast();
                }
                maxList.addLast(i);
        }
        System.out.print(arr[maxList.peek()]+" ");
        for (; i< arr.length; i++){
            while (!maxList.isEmpty() && maxList.peekFirst() <= i-k) {
                maxList.removeFirst();
            }
            while (!maxList.isEmpty() && arr[maxList.peekLast()] < arr[i]) {
                maxList.removeLast();
            }
            maxList.addLast(i);

            System.out.print(arr[maxList.peek()]+" ");

        }

    }
}
