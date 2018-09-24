class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] small = new int[n];
        int[] big = new int[n];
        small[0] = 1;
        big[0] = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] > nums[i-1]){
                big[i] = small[i-1] + 1;
                small[i] = small[i-1];
            }else if(nums[i] < nums[i-1]){
                small[i] = big[i-1] + 1;
                big[i] = big[i-1];
            }else{
                small[i] = small[i-1];
                big[i] = big[i-1];
            }
        }
        return Math.max(small[n-1], big[n-1]);
    }
}