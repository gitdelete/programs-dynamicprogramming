package com.aman.dynamic;

public class MaximumRectangleInBinaryMatrix {

    public static void main(String[] args) {
        int square[][]={
                        {0, 1, 1, 1},
                        {1, 1, 1, 0},
                        {0, 1, 1, 1},
                        {1, 1, 1, 1},
                        {1, 1, 1, 1}
                        };
        maxSquare(square,4,3);
    }

    private static void maxSquare(int[][] square, int m, int n) {
        for(int i=0; i<=m; i++){
            System.out.println();
            for(int j=0; j<=n; j++) {
                System.out.print(square[i][j]+" ");
            }
        }
        System.out.println("");
        int[][] checkMatrix = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0 || j==0){
                    checkMatrix[i][j]=square[i][j];
                }
                else{
                    if(square[i][j]==0){
                        checkMatrix[i][j]=0;
                    }else if (square[i][j]==1){
                        //System.out.println(checkMatrix[i-1][j]+" "+checkMatrix[i][j-1]+" "+checkMatrix[i-1][j-1]);
                        checkMatrix[i][j]=Math.min(Math.max(checkMatrix[i-1][j],checkMatrix[i][j-1]),checkMatrix[i-1][j-1])+1;
                    }
                }
            }
        }

        int max=0;
        int row=0; int col=0;
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++) {
                if(checkMatrix[i][j]>max){
                    max= checkMatrix[i][j];
                    row=i; col=j;
                }
            }
        }

        System.out.println("row "+row);
        System.out.println("col "+col);
        System.out.println("maxRect "+max);

        for(int i=0; i<=m; i++){
            System.out.println();
            for(int j=0; j<=n; j++) {
                System.out.print(checkMatrix[i][j]+" ");
            }
        }
        System.out.println(" ============================ ");
        for(int i=row; i>row-max; i--){
            System.out.println();
            for(int j=col; j>col-max; j--) {
                System.out.print(square[i][j]+" ");
            }
        }

    }
}
