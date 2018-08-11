class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) return 0;
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int ans = 0;
        Arrays.sort(nums);
        for(int i = 0; i < len-2; i++){
            int j = i + 1;
            int k = len -1;
            while(j < k){
                long sum = nums[i] + nums[j] + nums[k];
                if(sum == target){
                    return target;
                }else if(sum < target){
                    if(target - sum < min){
                        min = (int) (target - sum);
                        ans = (int) sum;
                    }
                    j ++;
                }else{
                    if(sum - target < min){
                        min = (int) (sum - target);
                        ans = (int) sum;
                    }
                    k --;
                }
            }
        }
        return ans;
    }
}