public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }   
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        
        int[] dr = new int[n];
        dr[0] = 0;
        dr[1] = nums[1];
        for(int i = 2; i < n; i++){
            dr[i] = Math.max(dr[i-1], dr[i-2] + nums[i]);
        }
        return Math.max(dp[n-1], dr[n-1]);
    }
}