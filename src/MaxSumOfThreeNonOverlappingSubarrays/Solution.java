class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int len = nums.length;
        int[][] dp = new int[4][len];
        int[] sum = new int[len+1];
        for(int i = 0; i < len; i++){
            sum[i+1] = sum[i] + nums[i];
        }
        int[][] id = new int[4][len];

        for(int i = 1; i < 4; i++){
            for(int j = k -1; j < len; j++){
                int tmp = sum[j + 1] - sum[j + 1 - k];
                if(j - k >= 0){
                    tmp += dp[i-1][j-k];
                    dp[i][j] = dp[i][j-1];
                    id[i][j] = id[i][j-1];
                }
                if(tmp > dp[i][j]){
                    dp[i][j] = tmp;
                    id[i][j] = j - k + 1;
                }
            }
        }
        int[] res = new int[3];
        res[2] = id[3][len -1];
        res[1] = id[2][res[2] -1];
        res[0] = id[1][res[1] -1];
        return res;
    }
}