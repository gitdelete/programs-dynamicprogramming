package com.aman.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
https://baihuqian.github.io/2018-08-16-range-addition/
 */

public class RangeAdditionProblem_InvestorPortfolio {

    public static void main(String[] args) {

        List<List<Integer>>  ranges = new ArrayList<>();
        List<Integer> range1 = new ArrayList<>();
        range1.add(2);
        range1.add(3);
        range1.add(10);
        ranges.add(range1);

        List<Integer> range2 = new ArrayList<>();
        range2.add(3);
        range2.add(4);
        range2.add(15);
        ranges.add(range2);

        List<Integer> range3 = new ArrayList<>();
        range3.add(1);
        range3.add(2);
        range3.add(17);
        ranges.add(range3);

        portfolio(ranges, 5);

    }

    // Complexity O(n)
    private static void portfolio(List<List<Integer>> updates, int size) {
        int[] arr = new int[size];
        Arrays.fill(arr, 0);

        for(int i = 0; i < updates.size(); i++) {
            arr[updates.get(i).get(0)] += updates.get(i).get(2);
            if(updates.get(i).get(1) < size - 1)
                arr[updates.get(i).get(1) + 1] -= updates.get(i).get(2);
        }

        for(int i = 0; i < size; i++) {
            System.out.print (arr[i]+ "  ");
        }

        for(int i = 1; i < size; i++) {
            arr[i] += arr[i - 1];
        }
        System.out.println();

        for(int i = 0; i < size; i++) {
            System.out.print (arr[i]+ "  ");
        }


    }

}
