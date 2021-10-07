package com.aman.dynamic;

public class PathsFromPointToOriginAxis {
     
    static int[][] countPaths(int n, int m)
    {
        int dp[][] = new int[n + 1][m + 1];
     

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp;
    }

    private static int countPathsRecusively(int n, int m) {

        if(m ==0 || n == 0)
            return 1;

        return countPathsRecusively(n-1,m) +countPathsRecusively(n, m-1);
    }

    static void printSolution(int K[][], int n, int m)
    {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++)
                System.out.print(" " + K[i][j]
                        + " ");
            System.out.println();
        }
    }
     
    public static void main (String[] args) {
        int n = 6, m = 2;
        int dp[][]=countPaths(n, m);
        printSolution(dp, n, m);


        System.out.println("With recursion");
        int countPaths=countPathsRecusively(n,m);
        System.out.println(countPaths);
    }


}
