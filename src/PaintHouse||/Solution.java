public class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0){
            return 0;
        }   
        
        int n = costs.length;
        int k = costs[0].length;
        
        int min1 = 0;
        int min2 = 0;
        int[] dp = new int[k];
        
        for(int i = 0; i < n; i++){
            int prevMin1 = min1;
            int prevMin2 = min2;
            
            min1 = Integer.MAX_VALUE;
            min2 = Integer.MAX_VALUE;
            
            for(int j = 0; j < k; j++){
                if(dp[j] != prevMin1 || prevMin1 == prevMin2){
                    dp[j] = prevMin1;
                }else{
                    dp[j] = prevMin2;
                }
                
                dp[j] += costs[i][j];
                
                if(min1 <= dp[j]){
                    min2 = Math.min(min2, dp[j]);
                }else{
                    min2 = min1;
                    min1 = dp[j];
                }
            }
        }
        
        return min1;
    }
}