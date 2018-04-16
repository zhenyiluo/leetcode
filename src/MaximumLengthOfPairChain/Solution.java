class Solution {
    public int findLongestChain(int[][] pairs) {
        if(pairs == null || pairs.length == 0) return 0;
        int n = pairs.length;
        Arrays.sort(pairs, (int[] a, int[] b) -> (a[1] - b[1]));
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ret = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(pairs[j][1] < pairs[i][0]){
                    if(dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                        ret = Math.max(ret, dp[i]);
                    }
                }
            }
        }
        return ret;
    }
}