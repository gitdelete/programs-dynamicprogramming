package com.aman.dynamic;

public class BuyingAndSellingStocksOnceMaxProfitProblem {

    public static void main(String[] args) {

        int[] stocks = { 200, 300, -400, 500, 600, 100, 200, 700, -300, -100, 100 };

        int minValue = stocks[0];
        int buyIndex = 0,sellIndex=0;
        int maxProfit= Integer.MIN_VALUE;
        for(int i = 0; i<stocks.length; i++){
            int profit= 0;
            if(stocks[i]>minValue){
                profit=stocks[i]-minValue;
                if(profit>maxProfit) {
                    maxProfit=profit;
                    sellIndex = i;
                }
            }
            else {
                buyIndex=i;
                minValue=stocks[i];
            }
        }
        System.out.println(maxProfit);
        System.out.println(buyIndex);
        System.out.println(sellIndex);

    }

}
