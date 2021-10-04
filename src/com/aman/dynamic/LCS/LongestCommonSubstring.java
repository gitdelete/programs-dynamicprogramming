package com.aman.dynamic.LCS;

public class LongestCommonSubstring {

    static int LCSubStr(char X[], char Y[],
                        int m, int n)
    {

        int LCStuff[][] = new int[m + 1][n + 1];

        int result = 0;

        for (int i = 0; i <= m; i++)
        {
            for (int j = 0; j <= n; j++)
            {
                if (i == 0 || j == 0)                       //String X = "AmanjotSinghDhingra";
                                                            // String Y = "HarmanjotSinghDhingra";
                    LCStuff[i][j] = 0;
                else if (X[i - 1] == Y[j - 1])
                {
                    LCStuff[i][j]
                            = LCStuff[i - 1][j - 1] + 1;
                    result = Integer.max(result,
                            LCStuff[i][j]);
                }
                else
                    LCStuff[i][j] = 0;
            }
        }

        printSolution(LCStuff,m,n);

        return result;
    }

    static void printSolution(int queens[][], int m, int n)
    {
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++)
                System.out.print(" " + queens[i][j]
                        + " ");
            System.out.println();
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        String X = "AmanjotSinghDhingra";
        String Y = "HarmanjotSinghDhingRa";

        int m = X.length();
        int n = Y.length();

        System.out.println(LCSubStr(X.toCharArray(),
                Y.toCharArray(), m,
                n));
    }
}
