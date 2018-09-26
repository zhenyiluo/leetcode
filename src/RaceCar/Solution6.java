class Solution {
    public int racecar(int target) {
        int[] dp = new int[target + 1];
        for(int i = 1; i <= target; i++){
            int m = 1;
            int j = 1;
            dp[i] = Integer.MAX_VALUE;
            for(; j < i; j = (1 << ++m) - 1){
                for(int n = 0, q = 0; q < j; q = (1 << ++ n) - 1){
                    dp[i] = Math.min(dp[i], m + 1 + n + 1 + dp[i - (j - q)]);
                }
            }
            if(j == i){
                dp[i] = Math.min(dp[i], m);
            }
            if(j > i){
                dp[i] = Math.min(dp[i], m + 1 + dp[j - i]);
            }
        }
        return dp[target];
    }
}