class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int lastSeen = -1;
        int ret = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                lastSeen = i;
            }else{
                ret = Math.max(ret, i - lastSeen);
            }
        }
        return ret;
    }
}