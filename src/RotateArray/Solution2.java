class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length <= 1){
            return;
        }
        k = k % nums.length;
        if(k == 0){
            return;
        }
        for(int j = 0; j < k; j++){
            int tmp = nums[nums.length -1];
            for(int i = nums.length -1; i>= 1; i--){
                nums[i] = nums[i-1];
            }
            nums[0] = tmp;
        }
        return;
    }
}