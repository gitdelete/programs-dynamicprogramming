package com.aman.dynamic;

public class DiceRoll {

    public static void main(String[] args) {
        int[] arr= {2,2,4,3};
        int[] check=solution(arr,2, 4);

        int[] arr1= {1,2,3,4};
        int[] check1=solution(arr1,4, 6);

        int[] arr2= {1,5,6};
        int[] check2=solution(arr2,4, 3);

        int[] arr3= {6,1};
        int[] check3=solution(arr3,1, 1);

        for(int i=0; i< check.length;i++){
            System.out.print(check[i]+"  ");
        }

        System.out.println("===================");

        for(int i=0; i< check1.length;i++){
            System.out.print(check1[i]+"  ");
        }

        System.out.println("===================");

        for(int i=0; i< check2.length;i++){
            System.out.print(check2[i]+"  ");
        }

        System.out.println("===================");

        for(int i=0; i< check3.length;i++){
            System.out.print(check3[i]+"  ");
        }
    }

    public static int[] solution(int[] A, int F, int M) {
        // write your code in Java SE 8

        int[] invalid = {0};
        int[] forgot = new int[F];
        //calculate
        int sum = 0;
        for(int i=0; i<A.length; i++){
            sum = sum+A[i];
        }
        int forgotTotal = ((A.length+F)*M)-sum;

        if(forgotTotal<0){
            return invalid;
        }

            double check = Double.valueOf(forgotTotal)/F;

        System.out.println("float"+check);

        if(check > 6){
            return invalid;
        }

        int mod = forgotTotal%F;
        int div = forgotTotal/F;

//        System.out.println(mod);
//        System.out.println(div);
//        System.out.println(F);
        for(int j =0 ; j<F; j++){
            if(mod>0){
                forgot[j]=div+1;
                mod--;
            }else{
                forgot[j]=div;
            }
        }



        return forgot ;
    }


}


// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

