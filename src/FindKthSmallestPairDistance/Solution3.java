class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0;
        int n = nums.length;
        int high = nums[n -1] - nums[0];
        while(low < high){
            int mid = low + (high - low) / 2;
            int cnt = 0;
            for(int i = 0; i < n -1; i ++){
                int j = helper(i+1, n, mid, nums);
                cnt += j - i -1;
            }
            if(cnt < k){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }

    private int helper(int start, int end, int target, int[] nums){
        int base = start -1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] - nums[base] <= target){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start;
    }
}