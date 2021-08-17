package com.aman.dynamic;

public class BuyingAndSellingStocks_NTimes_MaxProfitProblem {

    public static void main(String[] args) {

        int[] stocks = { 100, 180, 260, 310, 40, 535, 695 };
        int totalProfit=0;
        int minValue = stocks[0];
        int minIndex = 0;
        for (int i=1; i <stocks.length; i++){
            int profit = 0;
            if(stocks[i]<stocks[i-1]){
                profit=stocks[i-1]-minValue;
                System.out.println("Buy = "+minIndex+ " Sell "+ (i-1) + " profit = "+ profit);
                minValue=stocks[i];
                minIndex=i;
                totalProfit=totalProfit+profit;
            }else if (i==stocks.length-1){
                profit=stocks[i]-minValue;
                System.out.println("Buy = "+minIndex+ " Sell "+ (i) + " profit = "+ profit);
                minValue=stocks[i];
                minIndex=i;
                totalProfit=totalProfit+profit;
            }

        }

        System.out.println(totalProfit);
    }

}
