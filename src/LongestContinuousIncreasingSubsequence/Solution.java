class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] local = new int[2];
        int[] global = new int[2];
        local[0] = 1;
        global[0] = 1;
        for(int i = 1; i < n; i++){
            local[i%2] = nums[i] > nums[i-1] ? local[(i-1)%2] + 1 : 1;
            global[i%2] = Math.max(global[(i-1)%2], local[i%2]);
        }
        return global[(n-1)%2];
    }
}