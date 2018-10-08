class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while(i <= right){
            if(nums[i] == 2){
                swap(nums, i, right --);
            }else if(nums[i] == 0){
                swap(nums, i++, left ++);
            }else{
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int tmp= nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}