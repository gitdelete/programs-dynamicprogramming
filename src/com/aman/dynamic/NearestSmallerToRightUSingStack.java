package com.aman.dynamic;

import java.util.Stack;

public class NearestSmallerToRightUSingStack {

    public static void main(String[] args) {
        int[] arr = {2,4,1,6,3,8,18,4,23,11,20,42,1,23,7,9,10,16};

        findNearestSmallerToRight(arr);
    }

    private static void findNearestSmallerToRight(int[] arr) {

        Stack<Integer> stack = new Stack<>();

        for(int i=arr.length-1; i>0; i--){

            while(!stack.empty() && stack.peek()>arr[i]){
                stack.pop();
            }
            if(!stack.empty()){
                System.out.print(stack.peek()+" ");
            }else {
                System.out.print(-1 + " ");
            }
            stack.push(arr[i]);

        }

    }
}
