class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] max = new int[2];
        int[] min = new int[2];
        int[] global = new int[2];
        max[0] = nums[0];
        min[0] = nums[0];
        global[0] = nums[0];
        for(int i = 1; i < n; i++){
            max[i%2] = Math.max(Math.max(nums[i] * max[(i-1)%2], nums[i] * min[(i-1)%2]), nums[i]);
            min[i%2] = Math.min(Math.min(nums[i] * max[(i-1)%2], nums[i] * min[(i-1)%2]), nums[i]);
            global[i%2] = Math.max(global[(i-1)%2], max[i%2]);
        }
        return global[(n-1)%2];
    }
}