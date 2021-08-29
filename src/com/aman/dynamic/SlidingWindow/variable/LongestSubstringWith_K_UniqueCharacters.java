package com.aman.dynamic.SlidingWindow.variable;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWith_K_UniqueCharacters {

    public static void main(String[] args) {
        String arr[] = {"a", "b", "e", "a", "e", "a", "e", "a", "e", "a", "e", "a", "e", "a", "e", "a", "e", "a", "e", "f", "a", "a", "a", "b", "c", "a", "b", "d", "b", "b", "d", "b", "b", "d", "e", "e", "f", "e", "d", "f"};
        int k = 3; // "3 unique characters ! "

        longestSubstring(arr, k);
    }

    private static void longestSubstring(String[] arr, int k) {
        int count = 0;
        int maxCount=0;
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0, j=0; j < arr.length; j++) {

            if( !countMap.containsKey(arr[j]) && countMap.size() == k){
                    while(countMap.size()==k){
                        if(countMap.get(arr[i])>1) {
                            countMap.put(arr[i], countMap.get(arr[i]) - 1);
                        }
                        else {
                            countMap.remove(arr[i]);
                        }
                        i++;
                    }

            }
            if (countMap.containsKey(arr[j])) {
                countMap.put(arr[j], countMap.get(arr[j]) + 1);
            }else {
                countMap.put(arr[j],1);
            }
            count=j-i+1;
            System.out.println(i+"  "+ j);
            maxCount=Math.max(count,maxCount);
        }

        System.out.println(maxCount);

    }
}
