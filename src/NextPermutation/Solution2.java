class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int firstSmall = -1;
        int n = nums.length;
        for(int i = n-2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                firstSmall = i;
                break;
            }
        }
        if(firstSmall == -1){
            Arrays.sort(nums);
            return;
        }
        int firstLarge = -1;
        for(int i = n-1; i > firstSmall; i--){
            if(nums[i] > nums[firstSmall]){
                firstLarge = i;
                break;
            }
        }
        swap(nums, firstLarge, firstSmall);
        Arrays.sort(nums, firstSmall + 1, n);
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}