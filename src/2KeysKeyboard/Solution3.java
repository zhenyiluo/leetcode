class Solution {
    public int minSteps(int n) {
        if(n == 1) return 0;
        if(n == 2) return 2;
        if(n == 3) return 3;
        int[] dp = new int[n+1];
        dp[1] = 0;
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4; i <= n; i++){
            for(int j = i /2; j >= 1; j--){
                if(i % j == 0){
                    dp[i] = i / j + dp[j];
                    break;
                }
            }
        }
        return dp[n];
    }
}