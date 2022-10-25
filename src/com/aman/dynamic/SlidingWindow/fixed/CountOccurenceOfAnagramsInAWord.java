package com.aman.dynamic.SlidingWindow.fixed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountOccurenceOfAnagramsInAWord {

    public static void main(String[] args) {

        String word="sausidaisuudsdusidsidsiuiadiusuids";
        String ana="isu";
        countOccurrence(word, ana);

    }

    private static void countOccurrence(String word, String ana) {

        int characters = 256;
        int[] wordArray= new int[characters];
        int[] anaArray = new int[characters];
        int count=0;
        List<Integer> indexes = new ArrayList<>();
        int wordLength= word.length();
        int anaLength=ana.length();

        for(int i=0; i<anaLength; i++){
            wordArray[word.charAt(i)]++;
            anaArray[ana.charAt(i)]++;
        }
        if(Arrays.equals(wordArray,anaArray)){
            System.out.println(++count);
            indexes.add(0);
        }

        for (int i=anaLength; i<wordLength; i++){
            wordArray[word.charAt(i)]++;
            wordArray[word.charAt(i-anaLength)]--;
            if(Arrays.equals(wordArray,anaArray)){
                System.out.println(++count);
                indexes.add(i-anaLength+1);
            }
        }

        System.out.println(indexes);
    }
}
