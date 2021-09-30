package com.aman.dynamic;

import java.lang.reflect.Array;
import java.util.*;

public class GroupAnagramsTogetherInArray {

    public static void main(String[] args) {

        String wordArr[] = { "cat", "dog", "tac", "god", "act", "cow","owc", "owl" };
        int size = wordArr.length;
        printAnagramsTogether(wordArr, size);
    }

    private static void printAnagramsTogether(String[] wordArr, int size) {

        Map<String, List<String>> wordsMap = new HashMap<>();
        int[] charArray1 = new int[26];
        Arrays.fill(charArray1,0);
        int[] charArray2 = new int[26];
        Arrays.fill(charArray2,0);
        /* System.out.println(Integer.valueOf('a'));
        System.out.println(Integer.valueOf('z'));
        System.out.println('a'-97);
        System.out.println('z'-97); */
        boolean[] wordDone = new boolean[wordArr.length] ;
        Arrays.fill(wordDone,false);
        for(int i=0; i<size; i++){

            if(!wordDone[i]){
                for (int c = 0; c < wordArr[i].length(); c++) {
                    charArray1[wordArr[i].charAt(c) - 97]++;
                }
                List<String> list = new ArrayList<>();
                list.add(wordArr[i]);
                wordsMap.put(wordArr[i], list);

                for (int j = i + 1; j < size; j++) {
                    for (int c = 0; c < wordArr[j].length(); c++) {
                        charArray2[wordArr[j].charAt(c) - 97]++;
                    }
                    if (Arrays.equals(charArray1, charArray2)) {
                        wordsMap.get(wordArr[i]).add(wordArr[j]);
                        wordDone[j] = true;
                    }
                    Arrays.fill(charArray2, 0);
                }
            }
            Arrays.fill(charArray1,0);
        }
        wordsMap.forEach( (K,V)-> V.forEach(a->System.out.print(a + " ")));
    }

}
