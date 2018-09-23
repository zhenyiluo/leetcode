class Solution {
    public int superEggDrop(int K, int N) {
        int[] dp = new int[K+1];
        int m = 0;
        while(dp[K] < N){
            m ++;
            for(int i = K; i >= 1; i--){
                dp[i] = dp[i] + dp[i-1] + 1;
            }
        }
        return m;
    }
}