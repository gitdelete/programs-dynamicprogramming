package com.aman.dynamic;

public class PrintAllSubsequencesOfAnArray {

    public static void main(String[] args) {
        int arr[] = {2,5,7,8};
        int temp[] = new int[arr.length];
        printAllSubsequencesRecusively(arr, temp, 0);
        printAllSubsequencesIterativeBitMasking(arr);
    }

    private static void printAllSubsequencesRecusively(int[] arr, int[] temp, int index) {

        if(index== arr.length){
            print(temp);
            return;
        }
        temp[index]=arr[index];
        printAllSubsequencesRecusively(arr, temp, index+1);
        temp[index]=0;
        printAllSubsequencesRecusively(arr, temp, index+1);
    }

    private static void print(int[] temp) {
        for(int i=0; i<temp.length; i++){
            System.out.print(temp[i]+" ");
        }
        System.out.println();
    }


    private static void printAllSubsequencesIterativeBitMasking(int[] arr) {

        int subset_size = (int)Math.pow(2,arr.length);

        for(int i=0; i<subset_size; i++){

            for(int j=0; j<arr.length; j++){
//                System.out.println("i "+i+" j "+j+" test1  "+(1 << j));
//                System.out.println("i "+i+" j "+j+" test2  "+(i&(1 << j)));
                if ((i & (1 << j)) != 0) {
                    System.out.print(arr[j]+" ");
                }
            }
            System.out.println();
        }

    }


}
