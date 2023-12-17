package com.aman.dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindWordCoordinatesInMatrix {

    public static void main(String[] args) {
        char[][] matrix = {
                            {'A','M','A','N','J'},
                            {'J','O','T','S','I'},
                            {'A','J','O','T','N'},
                            {'A','A','J','O','N'},
                            {'A','M','A','J','O'},
                          };
        String word1 ="AOOOO";
        findWordInMatrix(matrix,word1);
        String word2 ="AOOTN";
        findWordInMatrix(matrix,word2);
        String word3 ="AOOSI";
        findWordInMatrix(matrix,word3);
    }


    private static void findWordInMatrix(char[][] matrix, String word) {
        System.out.println(word);
        for(int i=0; i <matrix.length; i++){
            for(int j=0; j <matrix[0].length; j++){

                if(matrix[i][j]== word.charAt(0)){
                //    System.out.println("i--- "+i+" j---- "+j);
                    nextCoordinates(matrix, word, i,j,0,0,1, (""+i+" "+j));
                }

            }
        }
    }

    private static void nextCoordinates(char[][] matrix, String word,int i, int j,int m,int n,int index, String s){

        int[] directionI = {-1,-1,-1,0,1,1,1,0};
        int[] directionJ = {-1,0,1,1,1,0,-1,-1};

        if(word.length() == index){
            System.out.println("Found ...... ");
            System.out.println(s);
            return;
        }

        if(word.length() < index){
           // System.out.println("Not Found ...... ");
            return;
        }
        if(m<8 && n<8 ) {
            if (((i + directionI[m]) >= 0) && ((i + directionI[m]) <= matrix[0].length - 1)
                    && ((j + directionJ[n]) >= 0) && ((j + directionJ[n]) <= matrix[0].length - 1)) {
                if (matrix[i + directionI[m]][j + directionJ[n]] == word.charAt(index)) {
                    s=s+"\n"+(i + directionI[m])+" "+(j + directionJ[n]);
                    nextCoordinates(matrix, word, i+directionI[m], j+directionJ[n], 0, 0, index + 1, s);
                } else {
                    nextCoordinates(matrix, word, i, j, m + 1, n + 1, index, s);
                }
            } else {
                nextCoordinates(matrix, word, i, j, m + 1, n + 1, index, s);
            }
        }else {
            return;
        }
        return;
    }


}
