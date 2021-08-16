package com.aman.dynamic.SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumOfAllSubarraysSizeK
{
    public static void main(String[] args) {
        int k = 3; // subarray fixed size
        int[] arr = {2,15,14,2,3,4,5,7,10,12,3,6,20,1,4,22};
        maxSumWindow(arr, k);
    }

    private static void maxSumWindow(int[] arr, int k) {
        int max=0;
        int i=0;
        Deque<Integer>  maxList = new LinkedList<>();

        for (i=0; i<k; i++) {
                while (!maxList.isEmpty() && arr[maxList.peek()] < arr[i]) {
                    maxList.removeLast();
                }
                maxList.addLast(i);
        }
        System.out.println(arr[maxList.peek()]);
        for (; i< arr.length; i++){
            while (!maxList.isEmpty() && maxList.peekFirst() <= i-k) {
                maxList.removeFirst();
            }
            while (!maxList.isEmpty() && arr[maxList.peekLast()] < arr[i]) {
                maxList.removeLast();
            }
            maxList.addLast(i);

            System.out.println(arr[maxList.peek()]);

        }

    }
}
