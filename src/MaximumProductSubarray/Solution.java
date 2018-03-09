class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int min = nums[0];
        int max = nums[0];
        int ret = nums[0];
        for(int i = 1; i < nums.length; i++){
            int tmp = max;
            max = Math.max(Math.max(nums[i] * min, nums[i] * max), nums[i]);
            min = Math.min(Math.min(nums[i] * min, nums[i] * tmp), nums[i]);
            ret = Math.max(max, ret);
        }
        return ret;
    }
}