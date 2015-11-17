public class Solution1 {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }

        if( k >= prices.length / 2){
            int ret = 0;
            for(int i = 1; i < prices.length; i++){
                ret += Math.max(0, prices[i] - prices[i-1]);
            }
            return ret;
        }
        int len = prices.length;
        int[][] local = new int[2][k+1];
        int[][] global = new int[2][k+1];

        for(int i = 1; i < len; i++){
            int diff = prices[i] - prices[i-1];
            for(int j = 1; j <= k; j++){
                local[i%2][j] = Math.max(global[(i-1) % 2][j-1] + diff, local[(i-1) %2][j] + diff);
                global[i%2][j] = Math.max(local[i % 2][j], global[(i-1) %2][j]);
            }
        }

        return global[(len-1) % 2][k];
    }
}


