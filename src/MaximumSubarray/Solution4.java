class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        for(int num: nums){
            sum += num;
            ans = Math.max(ans, sum);
            sum = Math.max(0, sum);
        }
        return ans;
    }
}