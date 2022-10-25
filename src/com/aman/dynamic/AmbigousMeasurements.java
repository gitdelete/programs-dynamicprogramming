package com.aman.dynamic;

public class AmbigousMeasurements {

    public static void main(String[] args) {

        int[][] measuringCups1 = {
                {200,210},
                {450,465},
                {800,850}
        };

        int low1=2100;
        int high1=2190;
        int lowSum = 0,highSum=0, row=0;
        boolean b1 = measurement(measuringCups1,low1,high1, lowSum, highSum, row);
        System.out.println(b1);

        int[][] measuringCups2 = {
                {1,3},
                {2,4},
                {5,6}
        };
        int low2=100;
        int high2=120;
        boolean b2 = measurement(measuringCups2,low2,high2, lowSum, highSum, row);

        System.out.println(b2);
    }

    private static boolean measurement(int[][] measuringCups, int low, int high, int lowSum, int highSum,int row) {

        if(row>measuringCups.length-1)
            return false;

        if(highSum > high)
            return false;

        if(lowSum >= low  && highSum <= high) {
            System.out.println(lowSum);
            System.out.println(highSum);
            return true;
        }

        if(measurement(measuringCups,low,high,lowSum+measuringCups[row][0],highSum+measuringCups[row][1],row)) {
            return true;
        }
        if(measurement(measuringCups,low,high,lowSum,highSum,row+1)) {
            return true;
        }

        return false;
    }


}
