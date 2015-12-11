public class Solution {
    
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;
        int[] index = new int[k];
        int[] dp = new int[n];
        dp[0] = 1;
        int cnt = 1;
        while(cnt < n){
            int min = findSmall(index, primes, dp);
            increment(min, primes, index, dp);
            dp[cnt] = min;
            cnt ++;
        }
        return dp[n-1];
    }

    private int findSmall(int[] index, int[] primes, int[] dp){
        int small = Integer.MAX_VALUE;
        int k = index.length;
        for(int i = 0; i < k; i++){
            small = Math.min(small, dp[index[i]] * primes[i]);
        }
        return small;
    }

    private void increment(int min, int[] primes, int[] index, int[] dp){
        int k = index.length;
        for(int i = 0; i < k; i++){
            if(min == dp[index[i]] * primes[i]){
                index[i] ++;
            }
        }
    }
}