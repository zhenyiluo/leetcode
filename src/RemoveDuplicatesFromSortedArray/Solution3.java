class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int cur = nums[0];
        int index = 1;
        for(int i = 1; i < nums.length; i++){
            if(cur != nums[i]){
                nums[index++] = nums[i];
                cur = nums[i];
            }
        }
        return index;
    }
}