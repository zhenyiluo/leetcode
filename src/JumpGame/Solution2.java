class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length <= 1) return true;
        int max = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(max < i) return false;
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}