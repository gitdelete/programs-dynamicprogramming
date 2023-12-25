package com.aman.dynamic;

/*
2517. Maximum Tastiness of Candy Basket

You are given an array of positive integers price where price[i] denotes the price of the ith candy and a positive integer k.
The store sells baskets of k distinct candies. The tastiness of a candy basket is the smallest absolute difference of the prices of any two candies in the basket.
Return the maximum tastiness of a candy basket.

Example 1:

Input: price = [13,5,1,8,21,2], k = 3
Output: 8
Explanation: Choose the candies with the prices [13,5,21].
The tastiness of the candy basket is: min(|13 - 5|, |13 - 21|, |5 - 21|) = min(8, 8, 16) = 8.
It can be proven that 8 is the maximum tastiness that can be achieved.
Example 2:

Input: price = [1,3,1], k = 2
Output: 2
Explanation: Choose the candies with the prices [1,3].
The tastiness of the candy basket is: min(|1 - 3|) = min(2) = 2.
It can be proven that 2 is the maximum tastiness that can be achieved.
*
    https://www.youtube.com/watch?v=M2GTMVYraP0
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Tastiness_Candy_Basket_BinarySearch {

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int low=0;
        int high=price[price.length-1];
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isValid(mid,price,k)){
                ans=mid;
                low=mid+1;
            }
            else
                high=mid-1;
        }
        return ans;
    }
    public boolean isValid(int target,int[] price,int k){
        int prev=price[0];
        int cnt=1;
        for(int i=1;i<price.length;i++){
            if(price[i]-prev>=target){
                cnt++;
                prev=price[i];
            }
        }
        if(cnt>=k)
            return true;
        return false;
    }

    // Another approach but exceeded time limit  (N * NlogN) -

    public int maximumTastiness_UsingSubsets(int[] price, int k) {

        int tastiness=Integer.MIN_VALUE;
        int pow = (int)Math.pow(2,price.length);

        List<Integer> list = new ArrayList<>();
        //finding all subset with bit manipulation
        for(int i = 0; i<pow; i++){
            for(int j=0; j<price.length; j++){
                //      System.out.println("j, 1<<j "+j+" "+(1<<j));
                if ((i & (1 << j)) != 0) {
                    list.add(price[j]);
                }
            }
            int tillNow= Integer.MAX_VALUE;
            if(list.size()==k){

                Collections.sort(list);
                for(int y=1; y<list.size(); y++){
                    tillNow=Math.min(tillNow,Math.abs(list.get(y-1)-list.get(y)));
                }
                if(tastiness<tillNow){
                    tastiness =tillNow;
                }
            }

            list.clear();
        }

        return tastiness;
    }

}


