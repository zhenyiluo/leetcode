class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums == null || nums.length <= 1) return 0;
        int start = -1;
        int end = -2;
        int n = nums.length;
        int min = nums[n-1];
        int max = nums[0];
        for(int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n-i-1]);
            if(nums[i] < max) end = i;
            if(nums[n-i-1] > min) start = n - i -1;
        }
        return end - start + 1;
    }
}