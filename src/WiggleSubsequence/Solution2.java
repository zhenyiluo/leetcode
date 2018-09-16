class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] large = new int[n];
        int[] small = new int[n];
        large[0] = 1;
        small[0] = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] > nums[i-1]){
                large[i] = small[i-1] + 1;
                small[i] = small[i-1];
            }else if(nums[i] < nums[i-1]){
                small[i] = large[i-1] + 1;
                large[i] = large[i-1];
            }else{
                small[i] = small[i-1];
                large[i] = large[i-1];
            }
        }
        return Math.max(large[n-1], small[n-1]);
    }
}