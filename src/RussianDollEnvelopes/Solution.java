class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) return 0;
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = 1;
        }
        int ans = 1;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(envelopes[j][0] > envelopes[i][0] && envelopes[j][1] > envelopes[i][1]){
                    if(dp[i] + 1 > dp[j]){
                        dp[j] = dp[i] + 1;
                        ans = Math.max(ans, dp[j]);
                    }
                }
            }
        }
        return ans;
    }
}