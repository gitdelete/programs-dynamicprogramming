package com.aman.dynamic;

public class InsertingInDigitFindMaximum {


    public static void main(String[] args) {

        int n= -333;
        int num=5;

        String  a= String.valueOf(n);

        String newDigit ="";

        boolean negativeNum= false;

        if(n<0){
            negativeNum= true;
        }

        boolean flagOnce = false;
        for(int i=0; i <a.length(); i++){
            System.out.println(Character.getNumericValue(a.charAt(i)));
            if(Character.getNumericValue(a.charAt(i))<num && !flagOnce && !negativeNum){
                newDigit=newDigit+String.valueOf(num);
                flagOnce=true;
            }

            if(Character.getNumericValue(a.charAt(i))>num && !flagOnce && negativeNum){
                newDigit=newDigit+String.valueOf(num);
                flagOnce=true;
            }

            newDigit += a.charAt(i);

        }

        System.out.println(newDigit);
    }

}
