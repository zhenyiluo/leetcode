public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount < 0){
            return -1;
        }
        if(amount == 0){
            return 0;
        }
        int n = amount;
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 0; i < n; i++){
            if(dp[i] != Integer.MAX_VALUE){
                for(int coin : coins){
                    if(i + coin <= n){
                        dp[i+coin] = Math.min(dp[i+coin], dp[i] + 1);
                    }
                }
            }
        }

        if(dp[n] == Integer.MAX_VALUE){
            return -1;
        }else{
            return dp[n];
        }

    }
}