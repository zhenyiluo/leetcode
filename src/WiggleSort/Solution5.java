class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int n = nums.length;
        for(int i = 0; i < n-1; i++){
            if(i % 2== 0){
                if(nums[i] > nums[i+1]){
                    swap(nums, i, i+1);
                }
            }else{
                if(nums[i] < nums[i+1]){
                    swap(nums, i, i+1);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}