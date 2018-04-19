class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = 0;
        for(int i = 0; i < nums.length; i ++){
            int j = i + 1;
            while(j < nums.length && nums[j] == nums[i]){
                j++;
            }
            nums[len++] = nums[i];
            i = j - 1;
        }
        return len;
    }
}