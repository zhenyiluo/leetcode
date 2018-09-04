class Solution {
    public int racecar(int target) {
        int[] dp = new int[target + 1];

        for(int i = 1; i <= target; i++){
            dp[i] = Integer.MAX_VALUE;
            int m = 1;
            int j = 1;
            for(; j < i; j = (1 << ++m) -1){
                for(int p = 0, q = 0; p < j; p = (1 << ++q) -1){
                    dp[i] = Math.min(dp[i], m + 1 + q + 1 + dp[i - (j - p)]);
                }
            }
            dp[i] = Math.min(dp[i], m + (j == i ? 0 : 1 + dp[j-i]));
        }

        return dp[target];
    }
}