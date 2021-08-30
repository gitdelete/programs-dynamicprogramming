package com.aman.dynamic;

public class PrintAllSubarrayOfArray {

    public static void main(String[] args) {
        int arr[] = {2,5,7,8};
        int temp[] = new int[arr.length];
        PrintAllSubarrayOfArrayRecusively(arr, temp, 0);
    }

    private static void PrintAllSubarrayOfArrayRecusively(int[] arr, int[] temp, int index) {

        if(index== arr.length){
            print(temp);
            return;
        }

        temp[index]=arr[index];
        PrintAllSubarrayOfArrayRecusively(arr, temp, index+1);
        temp[index]=0;
        PrintAllSubarrayOfArrayRecusively(arr, temp, index+1);
    }

    private static void print(int[] temp) {
        for(int i=0; i<temp.length; i++){
            System.out.print(temp[i]+" ");
        }
        System.out.println();
    }
}
