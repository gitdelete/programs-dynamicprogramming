package com.aman.dynamic;

public class MedianOfTwoSortedArrays_In_LogN_LogM {
    static double Median(int[] A, int[] B)
    {
        int n = A.length;
        int m = B.length;
        if (n > m) {
            System.out.println("   True   ");
            return Median(B,
                    A); // Swapping to make A smaller
        }
        int start = 0;
        int end = n;
        int realmidinmergedarray = (n + m + 1) / 2;
        System.out.println("realmidinmergedarray "+realmidinmergedarray );
        while (start <= end) {
            int mid = (start + end) / 2;
            System.out.println("mid "+mid );
            int leftAsize = mid;
            int leftBsize = realmidinmergedarray - mid;
            System.out.println("leftAsize leftBsize "+leftAsize+"  "+leftBsize );
            int leftA
                    = (leftAsize > 0)
                    ? A[leftAsize - 1]
                    : Integer
                    .MIN_VALUE; // checking overflow
            // of indices
            int leftB = (leftBsize > 0) ? B[leftBsize - 1]
                    : Integer.MIN_VALUE;
            int rightA = (leftAsize < n)
                    ? A[leftAsize]
                    : Integer.MAX_VALUE;
            int rightB = (leftBsize < m)
                    ? B[leftBsize]
                    : Integer.MAX_VALUE;

            // if correct partition is done
            if (leftA <= rightB && leftB <= rightA) {
                if ((m + n) % 2 == 0)
                    return (Math.max(leftA, leftB)
                            + Math.min(rightA, rightB))
                            / 2.0;
                return Math.max(leftA, leftB);
            }
            else if (leftA > rightB) {
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        return 0.0;
    }

    public static void main(String[] args)
    {
        int[] arr1 = { -5, 3, 6, 12, 15 };
        int[] arr2 = { -12, -10, -6, -3, 4, 10 };
        System.out.println("Median of the two arrays are");
        System.out.println(Median(arr1, arr2));
    }
}
