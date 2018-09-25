class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] cnt = new int[10001];
        for(int num: nums){
            cnt[num] ++;
        }
        int[] dp = new int[10001];
        dp[1] = cnt[1];
        dp[2] = Math.max(cnt[1], cnt[2] * 2);
        for(int i = 3; i <= 10000; i++){
            dp[i] = Math.max(cnt[i] * i + dp[i-2], dp[i-1]);
        }
        return dp[10000];
    }
}