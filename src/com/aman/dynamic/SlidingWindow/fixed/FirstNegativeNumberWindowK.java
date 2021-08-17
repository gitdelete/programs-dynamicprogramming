package com.aman.dynamic.SlidingWindow.fixed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeNumberWindowK {

    /*
    * for window size k= 3
    * output : -1,-5,-5,-5,-3,-12,0,0,-2,-2,-2,-1
    * */
    public static void main(String[] args) {
        int[] arr = {-1, 2, 3, -5, -3, -12,4,6,8,2,-2,10,-1,-1};

        Queue<Integer> negativeList = new LinkedList<>();
        int k =4;
        int i=0;
        for( i=0; i<k; i++){
            if(arr[i]<0)
                negativeList.add(i);
        }
        if(!negativeList.isEmpty()){
            System.out.println(arr[negativeList.peek()]);
        }else
        {
            System.out.println(0);
        }

        for(; i<arr.length; i++){

            //deleting first element of the previous window if present in list
            if(!negativeList.isEmpty() && i>negativeList.peek()+k-1){
                negativeList.poll();
            }

            if(arr[i]<0){
                negativeList.add(i);
            }
            if(!negativeList.isEmpty() ){
                System.out.println(arr[negativeList.peek()]);
            }else
            {
                System.out.println(0);
            }

        }

    }
}
