class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirstGreaterOrEqual(nums, target);
        if(first == nums.length || nums[first] != target){
            return new int[]{-1, -1};
        }
        int second = findFirstGreaterOrEqual(nums, target +1) -1;
        return new int[]{first, second};
    }

    private int findFirstGreaterOrEqual(int[] nums, int target){
        int low = 0;
        int high = nums.length;
        while(low < high){
            int mid = low + ((high - low) >> 1);
            if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }
}