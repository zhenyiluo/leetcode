class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int index = 0;
        int i = 0;
        while(i < nums.length){
            if(index > 1 && nums[index-2] == nums[i]){
                i ++;
            }else{
                nums[index++] = nums[i++];
            }
        }
        return index;
    }
}