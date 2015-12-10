public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        if(nums.length == 1){
            return 1;
        }
        
        int ret = 1;
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        for(int i = 1; i < len; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}