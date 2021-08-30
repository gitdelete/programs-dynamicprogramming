package com.aman.dynamic;

public class CompressString {

    public static void main(String[] args) {
        int k =3;
        String str = "aaabbbcccssjjjsjddbbbdccwerrrlllxxbbxxx";
        System.out.println(compressString(str, k));
        compressStringWithCount(str);
    }

    private static void compressStringWithCount(String str) {
        char prev= str.charAt(0);
        int count=1;
        for(int i=1; i < str.length(); i++){
            if(prev == str.charAt(i)){
                count++;
            }else {
                System.out.print(prev+"");
                if(count!=1)
                    System.out.print(count);
                prev = str.charAt(i);
                count=1;
            }
        }
        System.out.print(prev+""+count);
    }

    private static String compressString(String str, int k) {

        boolean flag = false;
        char prev= str.charAt(0);
        String newStr="";
        int count=1;
        int lastIndex=-1;
        for(int i=1; i < str.length(); i++){
            if(prev == str.charAt(i)){
                count++;
                if(count == k){
                    newStr=newStr+str.substring(lastIndex+1,i-k+1);
                    lastIndex=i;
                    count=1;
                    flag=true;
                }
            }else {
                prev = str.charAt(i);
                newStr=newStr+str.charAt(i);
                lastIndex=i;
                count=1;
            }
        }
        if (flag){
            str=newStr;
            return compressString(str,k);
        }
        return str;
    }


}
