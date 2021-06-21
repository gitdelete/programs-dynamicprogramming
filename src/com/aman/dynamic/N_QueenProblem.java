package com.aman.dynamic;

public class N_QueenProblem {


    public static void main(String[] args) {
        int count = 4;
        int[][] queens =new int[count][count];
        nQueen(queens, count,0);
        printSolution(queens,count);
    }

    private static boolean nQueen(int[][] queens, int count, int row) {

            if(row>=count){
                return true;
            }

           for(int j=0; j<count; j++) {
               if (isSafe(queens, row, j, count)) {
                   queens[row][j] = 1;
                   if(nQueen(queens,count, row+1))
                       return true;
                   queens[row][j] = 0;
               }
           }
        return false;
    }

    private static boolean isSafe(int[][] queens, int i,int j,int  count) {

        int col, row;

        /* Check this col on up side */
        for (row = 0; row < i; row++)
            if (queens[row][j] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (row=i, col = j; row >= 0 && col >= 0; row--, col--)
            if (queens[row][col] == 1)
                return false;

        /* Check upper diagonal on right side */
        for (row =i ,col = j; col >= 0 && row < count; row++, col--)
            if (queens[row][col] == 1)
                return false;

        return true;

    }

    static void printSolution(int queens[][], int count)
    {
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++)
                System.out.print(" " + queens[i][j]
                        + " ");
            System.out.println();
        }
    }
}
