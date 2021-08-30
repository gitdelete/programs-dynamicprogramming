package com.aman.dynamic;

public class AllAnagramsOfString {

    public static void main(String[] args) {
        String s="absg";
        char[] arr= new char[s.length()];
        permutation(s,0, s.length()-1);
    }

    private static void permutation(String s,int l, int r) {
        if (l == r)
            System.out.println(s);
        else
        {
            for (int i = l; i <= r; i++)
            {
                s = swap(s,l,i);
                permutation(s, l+1, r);
                s = swap(s,l,i);
            }
        }

    }
    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
