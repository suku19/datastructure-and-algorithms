package com.suku.array;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuySellStock {

    public static int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};

        System.out.println(maxProfit(nums));

        int[] nums1 = {100,180,260,310,40,535,695};

        System.out.println(maxProfit(nums1));
    }
}
