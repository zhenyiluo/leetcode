class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = nums[0];
        right[len-1] = nums[len-1];
        for(int i = 1; i < len; i++){
            if(i % k == 0){
                left[i] = nums[i];
            }else{
                left[i] = Math.max(left[i-1], nums[i]);
            }
            int j = len - i - 1;
            if(j % k == k - 1){
                right[j] = nums[j];
            }else{
                right[j] = Math.max(right[j+1], nums[j]);
            }
        }
        int[] ans = new int[len - k + 1];
        for(int i = 0; i + k <= len; i++){
            ans[i] = Math.max(right[i], left[i + k -1]);
        }
        return ans;
    }
}