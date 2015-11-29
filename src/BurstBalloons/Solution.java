public class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int len = nums.length;
        int[] val = new int[len + 2];
        val[0] = 1;
        val[len+1] = 1;
        for(int i = 1; i <= len; i++){
            val[i] = nums[i-1];
        }
        
        int[][] dp = new int[len+2][len+2];
        
        for(int l = 1; l <= len; l++){
            for(int start = 1; start + l -1 <= len; start++){
                int end = start + l -1;
                int bestVal = 0;
                for(int i = start; i <= end; i++){
                    int tmp = dp[start][i-1] + dp[i+1][end];
                    tmp += val[start-1] * val[i] * val[end+1];
                    bestVal = Math.max(bestVal, tmp);
                }
                dp[start][end] = bestVal;
            }
        }
        return dp[1][len];
    }
}