class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3) return 0;
        int ans = 0;
        int n = A.length;
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n-2; i++){
            if(A[i+1] - A[i] == A[i+2] - A[i+1]){
                dp[i][i+2] = true;
                ans++;
            }
        }
        for(int l = 4; l <= n; l ++){
            for(int i = 0; i + l <= n; i++){
                int j = i + l - 1;
                if(dp[i][j-1]){
                    if(A[j] - A[j-1] == A[j-1] - A[j-2]){
                        dp[i][j] = true;
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}