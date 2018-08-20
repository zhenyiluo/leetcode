class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length <= 3){
            int max = 0;
            for(int num: nums){
                max = Math.max(num, max);
            }
            return max;
        }
        int n = nums.length;
        int[] dp1 = new int[n-1];
        int[] dp2 = new int[n-1];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n-1; i++){
            dp1[i] = Math.max(nums[i] + dp1[i-2], dp1[i-1]);
        }
        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[1], nums[2]);
        for(int i = 3; i< n; i++){
            dp2[i-1] = Math.max(nums[i] + dp2[i-3], dp2[i-2]);
        }
        return Math.max(dp1[n-2], dp2[n-2]);
    }
}