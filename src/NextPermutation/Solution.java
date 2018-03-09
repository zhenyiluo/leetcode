class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1){
            return;
        }
        int len = nums.length;
        int posLeft = -1;
        for(int i = len -1; i >= 1; i --){
            if(nums[i-1] < nums[i]){
                posLeft = i-1;
                break;
            }
        }
        if(posLeft == -1){
            Arrays.sort(nums);
            return;
        }
        int posRight = findFirstNumberLarger(nums[posLeft], posLeft+1, len-1, nums);
        swap(nums, posLeft, posRight);
        Arrays.sort(nums, posLeft+1, len);
    }

    private int findFirstNumberLarger(int target, int start, int end, int[] nums){
        for(int i = end; i >= start; i--){
            if(nums[i] > target){
                return i;
            }
        }
        return -1;
    }

    private void swap(int[] nums, int l, int r){
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}