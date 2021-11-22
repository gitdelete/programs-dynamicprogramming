package com.aman.dynamic;

public class AmbigousMeasurements {

    public static void main(String[] args) {

        int[][] measuringCups = {
                {200,210},
                {450,465},
                {800,850}
        };
        int low=2100;
        int high=2190;
        int lowSum = 0,highSum=0, row=0;
        boolean b1 = measurement(measuringCups,low,high, lowSum, highSum, row);
        System.out.println(b1);
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

        if(measurement(measuringCups,low,high,lowSum+measuringCups[row][0],highSum+measuringCups[row][1],row))
            return true;
        if(measurement(measuringCups,low,high,lowSum+measuringCups[row][0],highSum+measuringCups[row][1],row+1))
            return true;


        return false;
    }


}
