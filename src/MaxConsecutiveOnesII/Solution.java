class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int zero = 0;
        int k = 1;
        for(int low = 0, high = 0; high < nums.length; high++){
            if(nums[high] == 0){
                zero ++;
            }
            while(zero > k){
                if(nums[low++] == 0){
                    zero --;
                }
            }
            max = Math.max(max, high - low + 1);
        }
        return max;
    }
}