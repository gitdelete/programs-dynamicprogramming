package com.aman.dynamic;

public class SubsetSumProblem {

    public static void main(String[] args) {

        int[] ar = {2,7,10,4,6,1,8,13};

        int sum = 3;

        boolean[][] K=findSubset(ar,sum);

        printSolution(K,sum,ar);

    }

    private static boolean[][] findSubset(int[] ar, int sum) {

        boolean[][] K = new boolean[ar.length+1][sum+1];


        for (int i =0 ; i<=ar.length; i++) {
            K[i][0] = true;
        }
        for (int j = 1; j <= sum; j++) {
            K[0][j] = false;
        }


        for (int i =1 ; i<=ar.length; i++){

            for(int j=1; j<=sum; j++){
                if(ar[i - 1]<= j)
                    K[i][j] = K[i - 1][j]
                            || K[i - 1][j - ar[i - 1]];
                else
                    K[i][j] = K[i - 1][j];

            }

        }

     //   System.out.print(K[ar.length][sum]);
      //  return K[ar.length][sum];
        return K;
    }

    static void printSolution(boolean K[][], int sum, int[] ar)
    {
        for (int i = 0; i <= ar.length; i++) {
            for (int j = 0; j <= sum; j++)
                System.out.print(" " + K[i][j]
                        + " ");
            System.out.println();
        }
    }
}
