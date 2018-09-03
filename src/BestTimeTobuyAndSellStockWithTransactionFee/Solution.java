class Solution {
    public int maxProfit(int[] prices, int fee) {
        if(prices == null || prices.length <= 1) return 0;
        int cash = 0;
        int hold = -prices[0];
        for(int i = 1; i < prices.length; i++){
            int tmp = cash;
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, tmp - prices[i]);
        }
        return cash;
    }
}