class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length <= 1 || k <= 0) return 0;
        if(k * 2 > prices.length){
            int profit = 0;
            for(int i = 1; i < prices.length; i++){
                profit += Math.max(0, prices[i] - prices[i-1]);
            }
            return profit;
        }

        int[] buy = new int[k];
        int[] sell = new int[k];
        for(int i = 0; i < k; i++){
            buy[i] = Integer.MAX_VALUE;
        }

        for(int price: prices){
            for(int i = 0; i < k; i++){
                buy[i] = Math.min(buy[i], price - ((i > 0) ? sell[i-1] : 0));
                sell[i] = Math.max(sell[i], price - buy[i]);
            }
        }
        return sell[k-1];
    }
}