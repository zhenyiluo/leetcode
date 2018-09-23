class Solution {
    public int racecar(int target) {
        int[] dp = new int[target +1];
        for(int i = 1; i <= target; i++){
            dp[i] = Integer.MAX_VALUE;
            int j = 1;
            int m = 1;
            for(; j < i; j = (1 << ++m) - 1){
                for(int p = 0, q = 0; p < j; p = (1 << ++q) -1){
                    dp[i] = Math.min(dp[i], m + 1 + q + 1 + dp[i - (j - p)]);
                }
            }
            if(j == i){
                dp[i] = Math.min(dp[i], m);
            }else if(j > i){
                dp[i] = Math.min(dp[i], m + 1 + dp[j - i]);
            }
        }
        return dp[target];
    }
}