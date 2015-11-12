public class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0){
            return 0;
        }
        
        int n = costs.length;
        int dp0 = costs[0][0];
        int dp1 = costs[0][1];
        int dp2 = costs[0][2];
        
        for(int i = 1; i < n; i++){
            int n0 = costs[i][0] + Math.min(dp1, dp2);
            int n1 = costs[i][1] + Math.min(dp0, dp2);
            int n2 = costs[i][2] + Math.min(dp0, dp1);
            
            dp0 = n0;
            dp1 = n1;
            dp2 = n2;
        }
        
        return Math.min(dp0, Math.min(dp1, dp2));
    }
}