package com.aman.dynamic;

//Unbounded 0-1 knapsack

import java.lang.reflect.Array;
import java.util.Arrays;

/*
 *              0   1   2   3   4   5
 *   coin   0   1   0   0   0   0   0
 *    1     1   1   1   1   1   1   1
 *    2     2   1   1   2   2   3   3
 *    3     3   1   1   2   3   4   5
 *    5     4   1   1   2   3   4   6
 *
 *  backtrack to find the weights selected
 *
 *
 */
public class CoinChangeNoOfWaysProblem {



    public static void main(String[] args) {

        int[] coins = {1,5,10};
        int result = 12;
        System.out.println(coinChange(coins, result));
        System.out.println(coinChangeSpaceOptimize(coins, result));

    }

    private static int coinChange(int[] coins, int result) {

        int[][] ways = new int[coins.length+1][result+1];
        for(int i=0; i<coins.length+1; i++) {
            for (int j = 0; j < result+1; j++) {

                if (i == 0 && j > 0) {
                    ways[i][j] = 0;
                }
                if (i >= 0 && j == 0) {
                    ways[i][j] = 1;
                }
            }
        }
        for(int i=1; i<coins.length+1; i++){
            for (int j=0; j<result+1; j++){

                if(coins[i-1]>j){
                    ways[i][j]=ways[i-1][j];
                }
                if(coins[i-1]<=j){
                    ways[i][j]=ways[i-1][j]+ways[i][j-coins[i-1]];
                }
            }
        }
        for(int i=0; i<ways.length; i++) {
            for (int j = 0; j < result; j++) {
                System.out.print(ways[i][j]+ "   ");
            }
            System.out.println(" ");
        }
        return ways[coins.length][result];
    }


    private static int coinChangeSpaceOptimize(int[] coins, int result) {

        int[] ways = new int[result+1];
        ways[0]=1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < ways.length; j++) {
                if (coins[i] <= j) {
                    ways[j] += ways[j - coins[i]];
                }
            }
        }
        return ways[result];
    }
}
