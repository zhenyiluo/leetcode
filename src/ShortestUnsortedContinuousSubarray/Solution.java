class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums == null || nums.length <= 1) return 0;
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        for(int i = 1; i < n; i++){
            left[i] = Math.max(left[i-1], nums[i]);
        }
        right[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--){
            right[i] = Math.min(right[i+1], nums[i]);
        }
        int low = 0;
        int high = n-1;
        while(low < n && nums[low] <= right[low]) low++;
        while(high >= 0 && nums[high] >= left[high]) high--;
        return Math.max(0, high - low + 1);
    }
}