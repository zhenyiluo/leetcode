public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int ret = Integer.MAX_VALUE;
        int start = -1;
        int cur = 0;
        int sum = 0;
        while(cur < nums.length){
            sum += nums[cur];
            if(sum >= s){
                while(start+ 1 < nums.length && sum - nums[start+1] >= s){
                    sum -= nums[++start];
                }
                ret = Math.min(ret, cur - start);
            }
            cur++;
        }
        if(ret == Integer.MAX_VALUE){
            return 0;
        }
        return ret;
    }
}