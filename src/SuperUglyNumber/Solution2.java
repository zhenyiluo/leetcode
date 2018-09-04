class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;
        int[] idxs = new int[k];
        int[] factors = new int[k];
        for(int i = 0; i < k; i++){
            factors[i] = 1;
        }
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            int min = Integer.MAX_VALUE;
            for(int factor: factors){
                min = Math.min(min, factor);
            }
            dp[i] = min;
            for(int j = 0; j < k; j ++){
                if(factors[j] == min){
                    factors[j] = primes[j] * dp[idxs[j]++];
                }
            }
        }
        return dp[n-1];
    }
}