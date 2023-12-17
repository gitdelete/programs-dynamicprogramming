package com.aman.dynamic;

import java.util.Stack;

public class LargestRectangularAreaInHistogram {


    public static void main(String[] args) {
        int[] histogram1 = {6, 2, 5, 4, 5, 1, 6};

        int[] histogram2 =  {3, 5, 1, 7, 5, 9};

        int histogram1Area = findArea(histogram1);
        System.out.println("Histogram 1 Largest Rectangular Area == "+ histogram1Area);
        int histogram2Area = findArea(histogram2);
        System.out.println("Histogram 2 Largest Rectangular Area == "+ histogram2Area);
    }

    private static int findArea(int[] histogram) {

        if(histogram.length==0 || histogram.length == 1){
            System.out.println("Invalid Histogram to find largest rectangle in histogram !!");
            return -1;
        }
        Stack<Integer> s1 = new Stack();


        int[] nearestSmallerToLeft = new int[histogram.length];
        int[] nearestSmallerToRight = new int[histogram.length];

        // Fill array nearestSmallerToLeft using Stack s1 for all histogram elements
        for(int i=0; i<histogram.length; i++){
            System.out.print(histogram[i]+" ");
        }
        System.out.println(" ");
        s1.push(0);
        nearestSmallerToLeft[0]=-1;
        for(int i=1; i<histogram.length; i++){
            while(!s1.empty() && histogram[s1.peek()]>histogram[i]){
                s1.pop();
            }
            if(s1.empty()){
                nearestSmallerToLeft[i]=-1;
            }else {
                nearestSmallerToLeft[i]=s1.peek();
            }
            s1.push(i);
        }
        for(int i=0; i<histogram.length; i++){
            System.out.print(nearestSmallerToLeft[i]+" ");
        }
        System.out.println(" ");
        s1.clear();
        // Fill array nearestSmallerToRight using Stack s2 for all histogram elements

        s1.push(histogram.length-1);
        nearestSmallerToRight[histogram.length-1]=-1;
        for(int i=histogram.length-2; i>=0; i--){
            while(!s1.empty() && histogram[s1.peek()]>histogram[i]){
                s1.pop();
            }
            if(s1.empty()){
                nearestSmallerToRight[i]=-1;
            }else {
                nearestSmallerToRight[i]=s1.peek();
            }
            s1.push(i);
        }
        for(int i=0; i<histogram.length; i++){
            System.out.print(nearestSmallerToRight[i]+" ");
        }
        System.out.println(" ");

        //Find Largest Area

        int maxArea=0;
        for(int i=0; i<histogram.length; i++){
            int area=0;
            if(nearestSmallerToLeft[i] == -1 && nearestSmallerToRight[i] == -1){
                area = (histogram.length-1-0)*histogram[i];
            }
            else if(nearestSmallerToLeft[i] == -1){
                area = (nearestSmallerToRight[i]-0)*histogram[i];
//                System.out.println(area);
            }
            else if(nearestSmallerToRight[i] == -1){
                area = (histogram.length-1-nearestSmallerToLeft[i])*histogram[i];
            }else {
                area = ((nearestSmallerToRight[i]-nearestSmallerToLeft[i])-1)*histogram[i];
            }
            maxArea =Math.max(maxArea,area);
        }

        return maxArea;
    }
}
