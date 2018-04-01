class Solution {
    public int maxProfit(int k, int[] prices) {
        if(k <= 0 || prices == null || prices.length <= 1) return 0;
        int n = prices.length;
        if(k >= n/2){
            return getProfit(prices);
        }
        int[][] local = new int[2][k+1];
        int[][] global = new int[2][k+1];

        for(int i = 1; i < n; i++){
            for(int j = 1; j <= k; j++){
                int diff = prices[i] - prices[i-1];
                local[i%2][j] = Math.max(local[(i-1)%2][j] + diff, global[(i-1)%2][j-1] + Math.max(0, diff));
                global[i%2][j] = Math.max(global[(i-1)%2][j], local[i%2][j]);
            }
        }
        return global[(n-1)%2][k];
    }

    private int getProfit(int[] prices){
        int ret = 0;
        for(int i = 1; i < prices.length; i++){
            ret += Math.max(0, prices[i] - prices[i-1]);
        }
        return ret;
    }
}