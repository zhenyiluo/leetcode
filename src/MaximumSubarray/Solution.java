class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int n : nums){
            sum = Math.max(sum + n, n);
            max = Math.max(max, sum);
        }
        return max;
    }
}