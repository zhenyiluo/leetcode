class Solution {
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0) return false;
        return canPartition(nums, sum/2);
    }

    private boolean canPartition(int[] nums, int target){
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for(int num: nums){
            for(int i = target ; i - num >= 0; i--){
                if(dp[i-num]){
                    dp[i] = true;
                }
            }
        }
        return dp[target];
    }
}