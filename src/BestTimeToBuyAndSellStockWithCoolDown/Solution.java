public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1){
            return 0;
        }
        int len = prices.length;
        int[] sell = new int[3];
        int[] buy = new int[2];
        buy[0] = -prices[0];
        
        for(int i = 1; i < len; i++){
            buy[i %2] = Math.max(sell[(i+1)%3] - prices[i], buy[(i-1) % 2]);
            sell[i %3] = Math.max(buy[(i-1) % 2] + prices[i], sell[(i-1) % 3]);
        }
        
        return sell[(len-1) % 3];
    }
}