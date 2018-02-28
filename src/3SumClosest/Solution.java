class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ret = 0;
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length -2; i ++){
            int j = i + 1;
            int k = nums.length -1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(sum - target);
                if(diff < min){
                    min = diff;
                    ret = sum;
                }
                if(diff == 0) return target;
                if(sum - target > 0){
                    k --;
                }else{
                    j++;
                }
            }
        }
        return ret;
    }
}