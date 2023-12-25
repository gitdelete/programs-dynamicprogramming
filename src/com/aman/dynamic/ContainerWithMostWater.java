package com.aman.dynamic;

/*

11. Container With Most Water

You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.



Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
*
*       https://leetcode.com/problems/container-with-most-water/description/?envType=featured-list&envId=top-100-liked-questions%3FenvType%3Dfeatured-list&envId=top-100-liked-questions
*
* */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int point1=0;
        int point2=height.length-1;
        int res=0;
        while(point1<point2){
            int min=Math.min(height[point1],height[point2]);
            int width=point2-point1;
            res=Math.max(res,min*width);
            if(height[point1]<height[point2]){
                point1++;
            }
            else{
                point2--;
            }
        }
        return res;
    }
}
