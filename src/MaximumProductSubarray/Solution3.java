class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int min = 1;
        int max = 1;
        int ans = Integer.MIN_VALUE;
        for(int num: nums){
            int minTmp = min;
            min = Math.min(Math.min(min * num, max * num), num);
            max = Math.max(Math.max(minTmp * num, max * num), num);
            ans = Math.max(ans, max);
        }
        return ans;
    }
}