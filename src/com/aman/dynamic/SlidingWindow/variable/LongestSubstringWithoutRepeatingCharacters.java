package com.aman.dynamic.SlidingWindow.variable;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String arr[] = {"a", "b", "d", "e", "e", "f", "e", "d", "f","x","z","f","g","i","p","q","w","e","r","t","y", "f","d"};
        longestSubstring(arr);
    }

    private static void longestSubstring(String[] arr) {

        int count=0;
        int longestCount=0;
        int begin=0;
        int end =0;
        Map<String,Integer> uniqueMap = new HashMap<>();

        int j=0;
        for(int i=0; i<arr.length; i++){

            count++;
            while(uniqueMap.containsKey(arr[i])){
                uniqueMap.remove(arr[j]);
                j++;
                if(count> longestCount){
                    begin=j;
                    end=i;
                    longestCount=count;
                    count=0;
                }
            }
            uniqueMap.put(arr[i],i);

        }
        if(count> longestCount){
            begin=j;
            end=arr.length-1;
            longestCount=count;
            count=0;
        }


        System.out.println(longestCount);
        System.out.println(begin);
        System.out.println(end);


    }
}
