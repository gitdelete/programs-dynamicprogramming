package com.aman.dynamic;

public class KnapsackPractice {

    public static void main(String[] args) {

        int[] weights = {1, 2, 3, 5};
        int[] values = {4, 3, 7, 6};

        int maxCapacity = 5;
        
        knapsack(weights, values, maxCapacity);

    }

    private static void knapsack(int[] weights, int[] values, int maxCapacity) {


        int[][] knap = new int[weights.length+1][maxCapacity+1];

        for(int i=0; i<=weights.length ; i++){

            for (int j=0; j<=maxCapacity; j++){

                if(i ==0 || j==0){
                    knap[i][j] = 0;
                }

                while(weights[i]>j){
                    knap[i][j]= knap[i-1][j];
                }
                if(weights[i-1]<=j){
                   knap[i][j]= Math.max(knap[i-1][j], values[i-1]+knap[i-1][j-weights[i-1]]);
                }

            }

        }


    }
}
