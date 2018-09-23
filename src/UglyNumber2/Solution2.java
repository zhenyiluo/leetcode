class Solution {
    public int nthUglyNumber(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        int x = 0;
        int y = 0;
        int z = 0;
        int val = 1;
        for(int i = 1; i < n; i++){
            int small = Math.min(2 * dp[x], Math.min(3 * dp[y], 5 * dp[z]));
            if(small == 2 * dp[x]){
                x++;
            }
            if(small == 3 * dp[y]){
                y ++;
            }
            if(small == 5 * dp[z]){
                z ++;
            }
            dp[i] = small;
        }

        return dp[n-1];
    }
}