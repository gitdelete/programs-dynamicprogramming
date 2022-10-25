package com.aman.dynamic.LCS;

public class LongestPallindromeSubsequence_LCS {

    /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
    int lcs( char[] X, char[] Y, int m, int n )
    {
        int L[][] = new int[m+1][n+1];

    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
        that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i-1] == Y[j-1])
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = max(L[i-1][j], L[i][j-1]);
            }
        }

        printSolution(L,m,n);
        return L[m][n];
    }

    /* Utility function to get max of 2 integers */
    int max(int a, int b)
    {
        return (a > b)? a : b;
    }
    static void printSolution(int LCStuff[][], int m, int n)
    {
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++)
                System.out.print(" " + LCStuff[i][j]
                        + " ");
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        LongestPallindromeSubsequence_LCS lcs = new LongestPallindromeSubsequence_LCS();
        StringBuilder sb1 = new StringBuilder("abcdxcbbcxyzzy");


        char[] X= sb1.toString().toCharArray();

        StringBuilder sb2=sb1.reverse();
        char[] Y= sb2.toString().toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LC paliindromic Subsequence is" + " " +
                lcs.lcs( X, Y, m, n ) );
    }

}
