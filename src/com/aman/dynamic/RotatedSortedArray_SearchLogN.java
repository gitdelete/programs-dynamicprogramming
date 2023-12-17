package com.aman.dynamic;

public class RotatedSortedArray_SearchLogN {

        public static void main(String[] args) {
            int[] nums = {4,5,6,7,0,1,2};
            int target = 0;
            int index = search(nums,target);
            System.out.println(index);
        }

        public static int search(int[] nums, int target) {
            int start=0;
            int end =nums.length-1;
            if(nums.length ==0){
                return -1;
                }
            if(nums.length==1){
                if(target == nums[start]){
                    return start;
                }else{
                    return -1;
                }
            }
            int mid=-1;
            while(start<=end){

                mid = (start+end)/2;

                if(nums[mid] == target){
                    return mid;
                }

                if(nums[start]<=nums[mid]){
                    if(target>=nums[start] && target<nums[mid]){
                        end=mid-1;
                    }else{
                        start=mid+1;

                    }
                }else{
                    if(target>nums[mid] && target<=nums[end]){
                        start=mid+1;

                    }else{

                        end=mid-1;
                    }
                }
            }
                return -1;
        }
}
