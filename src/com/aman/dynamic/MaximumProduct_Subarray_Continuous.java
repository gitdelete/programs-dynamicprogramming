package com.aman.dynamic;

public class MaximumProduct_Subarray_Continuous {

    public static Long maxProduct(int[] nums) {
        Long maxi = Long.MIN_VALUE;
        Long prod=1L;

        for(int i=0;i<nums.length;i++)
        {
            prod*=nums[i];
            maxi=Math.max(prod,maxi);
            if(prod==0)
                prod=1L;
        }
        prod=1L;
        for(int i=nums.length-1;i>=0;i--)
        {
            prod*=nums[i];

            maxi=Math.max(prod,maxi);
            if(prod==0)
                prod=1L;
        }
        return maxi;
    }

    public static void main(String[] args) {
        int[] ar = {2,-5,3,-1,-1,-3,5,10,3,-32,4,3,12,-10,-1,3,4,3,12};

        Long maxProduct = maxProduct(ar);
        System.out.println(maxProduct);
    }
}
