public class Solution {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int n = nums.length;
        return n * (n+1) / 2 - sum;
    }
}