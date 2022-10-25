package com.aman.dynamic;

public class BuyingAndSellingStocksOnceMaxProfitProblem {

    public static void main(String[] args) {

        int[] stocks = { 2000, 300, -400, 900,-500, 600, 100, -700,-700,1200,200, 100, -300, -100, 100 };

        int minValue = stocks[0];
        int buyIndex = 0,sellIndex=0, newBuyIndex=0;
        int maxProfit= Integer.MIN_VALUE;
        for(int i = 0; i<stocks.length; i++){
            int profit= 0;
            if(stocks[i]>minValue){
                profit=stocks[i]-minValue;
                if(profit>maxProfit) {
                    maxProfit=profit;
                    sellIndex = i;
                    buyIndex=newBuyIndex;
                }
            }
            else {
                newBuyIndex=i;
                minValue=stocks[i];
            }
        }
        System.out.println(maxProfit);
        System.out.println(buyIndex);
        System.out.println(sellIndex);

    }

}
