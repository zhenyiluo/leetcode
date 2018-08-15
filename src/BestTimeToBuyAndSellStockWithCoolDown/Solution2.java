class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int profit1 = 0;
        int profit2 = 0;
        for(int i = 1; i < prices.length; i++){
            int tmp = profit1;
            profit1 = Math.max(profit1 + prices[i] - prices[i-1], profit2);
            profit2 = Math.max(tmp, profit2);
        }
        return Math.max(profit1, profit2);
    }
}
