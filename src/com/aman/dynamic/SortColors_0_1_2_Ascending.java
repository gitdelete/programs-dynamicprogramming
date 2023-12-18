package com.aman.dynamic;

import java.util.Arrays;

public class SortColors_0_1_2_Ascending {

    public static void sortColors(int[] nums) {
        int countZero =0;
        int countOne =0;
        int countTwo =0;

        for(int i= 0; i<nums.length; i++){

            if(nums[i]==0)
                countZero++;
            else if(nums[i]==1)
                countOne++;
            else
                countTwo++;
        }

        for(int i =0; i<nums.length; i++){
            if(i<countZero)
                nums[i]=0;
            else if(i>=countZero && i<countZero+countOne)
                nums[i]=1;
            else
                nums[i]=2;
        }
    }

    public static void main(String[] args) {
        int nums[] = {0,2,1,2,1,2,1,0,0,2,1,0,1,1,1,2};
        sortColors(nums);
        Arrays.stream(nums).forEach(a->System.out.print(a+" "));
    }
}

/*
 public void sortColors(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                swap(nums, left, right); left++;
            }
        }
        for (int right = left; right < nums.length; right++) {
            if (nums[right] == 1) {
                swap(nums, left, right); left++;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
* */
