package com.aman.dynamic;



/*
*               0   1   2   3   4   5
*           0   0   0   0   0   0   0
* 4   1     1   0   4   4   4   4   4
* 3   2     2   0   4   4   7   7   7
* 7   3     3   0   4   4   7   11  11
* 6   5     4   0   4   4   7   11  11
*
*     backtrack to find the weights selected
*
*
 */
public class KnapsackProblem {

    public static void main(String[] args) {

        int[] weights = {1, 2, 3, 5};
        int[] values = {4, 3, 7, 6};

        int maxCapacity = 5;
        
        findMaxProfit(weights, values, maxCapacity);

    }

    private static int findMaxProfit(int[] weights, int[] values, int maxCapacity) {

        int[][] K = new int[weights.length+1][maxCapacity+1];
        int i,w=0;
        for ( i =0 ; i<=weights.length; i++){

            for( w=0; w<=maxCapacity; w++){

                if(i==0 || w==0)
                    K[i][w]=0;

                else if(weights[i - 1]<= w)
                    K[i][w] = Math.max(K[i-1][w], (values[i-1]+K[i-1][w-weights[i-1]]));
                else
                    K[i][w] = K[i - 1][w];

            }

        }

        System.out.print(K[weights.length][maxCapacity]);
        return 1;
    }

}
