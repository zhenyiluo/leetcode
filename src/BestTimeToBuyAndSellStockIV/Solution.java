public class Solution {
    public int maxProfit(int k, int[] prices) {
        if(k == 0){
            return 0;
        }
        
        if(prices == null || prices.length <= 1){
            return 0;
        }
        
        int len = prices.length;
        
        if(k > len / 2){
            int profit = 0;
            for(int i = 1; i < len; i++){
                profit += Math.max(0, prices[i] - prices[i-1]);
            }
            return profit;
        }
        
        int[][] global = new int[len][k+1];
        int[][] local = new int[len][k+1];
        for(int i = 1; i < len; i++){
            for(int j = 1; j <= k; j++){
                int diff = prices[i] - prices[i-1];
                local[i][j] = Math.max(global[i-1][j-1] + Math.max(0, diff), local[i-1][j] + diff);
                global[i][j] = Math.max(global[i-1][j], local[i][j]);
            }
        }
        return global[len-1][k];
    }
}