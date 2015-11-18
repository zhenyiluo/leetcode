public class Solution2 {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length <= 1){
            return;
        }
        int len = nums.length;
        for(int i = 1; i < len; i++){
            if((i % 2 == 1 && nums[i] < nums[i-1])||(i % 2 == 0 && nums[i] > nums[i-1])){
                swap(nums, i, i-1);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}