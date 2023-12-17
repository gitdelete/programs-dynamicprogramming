package com.aman.dynamic;

public class SetMatrixZerosForColAndROw {

    public static void main(String[] args) {

        int[][] matrix = {  {1,1,0,0,1,1},
                            {1,1,1,1,0,1},
                            {1,1,1,1,1,1},
                            {0,1,1,0,0,0}
                          };


        int row = matrix.length;
        if(row==0){
            System.out.println("Matrix Size is Zero !!! ");
            return;
        }
        int col = matrix[0].length;
        setZeros(matrix, row, col);
    }

    // first row and col will track if rows and columns have zeros
    private static void setZeros(int[][] matrix, int m, int n) {

        boolean firstRow = false;
        boolean firstCol = false;

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                System.out.print(matrix[i][j]+ "  ");
            }
            System.out.println(" ");
        }
        System.out.println("==================== ");
        for (int i=0; i<m ;i++){
            if(matrix[i][0]==0) {
                firstCol = true;
                break;
            }

        }

        for (int j=0; j<n ;j++){
            if(matrix[0][j]==0) {
                firstRow = true;
                break;
            }

        }
        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                if(matrix[i][j]==0){
                    matrix[0][j] =0;
                    matrix[i][0] = 0;
                }
            }
        }



        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                System.out.print(matrix[i][j]+ "  ");
            }
            System.out.println(" ");
        }
        System.out.println("==================== ");
        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                if(matrix[0][j]==0 || matrix[i][0]==0){
                    matrix[i][j]=0;
                }
            }
        }

        if (firstCol == true) {
            for (int i = 0; i < m; i++) {
                matrix[i][0]=0;
            }
        }

        if(firstRow == true) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }


        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                System.out.print(matrix[i][j]+ "  ");
            }
            System.out.println(" ");
        }
    }

}
