class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        for(int num : nums){
            count[num] ++;
        }
        int[] dp = new int[10001];
        dp[1] = count[1];
        dp[2] = Math.max(count[1], 2 * count[2]);
        for(int i = 3; i <= 10000; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + count[i] * i);
        }
        return dp[10000];
    }
}