class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1, -1};
        int idx1 = findFirstEqualOrLarger(nums, target);
        if(idx1 == nums.length || nums[idx1] != target) return new int[]{-1, -1};
        int idx2 = findFirstEqualOrLarger(nums, target + 1) -1;
        return new int[]{idx1, idx2};
    }

    private int findFirstEqualOrLarger(int[] nums, int target){
        int start = 0;
        int end = nums.length;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] >= target){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
}