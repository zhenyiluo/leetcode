class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int leftIndex = -1;
        int n = nums.length;
        for(int i = n-2; i>= 0; i --){
            if(nums[i] < nums[i+1]){
                leftIndex = i;
                break;
            }
        }
        if(leftIndex == -1){
            reverse(nums, 0, n -1);
            return;
        }
        int rightIndex = n -1;
        for(int i = n-1; i > leftIndex; i--){
            if(nums[i] > nums[leftIndex]){
                rightIndex = i;
                break;
            }
        }
        swap(nums, leftIndex, rightIndex);
        reverse(nums, leftIndex + 1, n -1);
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int i, int j){
        while(i < j){
            swap(nums, i++, j--);
        }
    }
}