class Solution {
    public double new21Game(int N, int K, int W) {
        if(K <= 0 || N >= K + W) return 1;
        double ans = 0;
        double[] dp = new double[N+1];
        dp[0] = 1;
        double WSum = 1;
        for(int i = 1; i <= N; i++){
            dp[i] = WSum / W;
            if(i < K) {
                WSum += dp[i];
            }else{
                ans += dp[i];
            }
            if(i - W >= 0) WSum -= dp[i-W];
        }
        return ans;
    }
}