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
        String word3 ="AOOZO";
        findWordInMatrix(matrix,word3);
    }

    private static void findWordInMatrix(char[][] matrix, String word) {
        for(int i=0; i <matrix.length; i++){
            for(int j=0; j <matrix[0].length; j++){
                Map<Character,List<Coordinates>> coordinatesMap = new HashMap<>();
                if(matrix[i][j]==word.charAt(0)){
                    List<Coordinates> list = new ArrayList<>();
                    list.add(new Coordinates(i,j));
                    coordinatesMap.put(word.charAt(0),list);
                    int x=i; int y=j;
                    for(;x< matrix.length;){
                        for (;y< matrix[0].length;){

                        }
                    }
                }

            }
        }
    }

    static class Coordinates{
        int m,n;
        Coordinates(int m, int n){
            this.m=m;
            this.n=n;
        }
    }
}
