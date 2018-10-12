class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int cnt = 0;
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i-1] < nums[i]){
                ans = Math.max(ans, ++cnt);
            }else{
                cnt = 1;
            }
        }
        return ans;
    }
}