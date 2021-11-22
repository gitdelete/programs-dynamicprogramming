package com.aman.dynamic;

import java.util.Arrays;

public class ReverseArrayInGroupOfSizeN {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
        int k=5;
        reverse(arr,k);

        Arrays.stream(arr).forEach(a->System.out.print(a+" "));
    }

    private static void reverse(int[] arr, int k) {
        int size=arr.length-1;
        int set=0;
        for(int i=0 ; i+k<=size;){
            int m=i;
            int n=i+k;
            set=set+k;
            while(m<n-1){
                swap(arr,m,n-1);
                m++;
                n--;
            }
            i=set;
        }

        while(set<size){
            swap(arr,set,size);
            set++;
            size--;
        }

    }

    private static void swap(int[] arr, int m, int n) {
        int temp = arr[m];
        arr[m]=arr[n];
        arr[n]=temp;
    }
}
