class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length <= 2) return 0;
        Arrays.sort(nums);
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 0; i < n-2; i++){
            int j = i + 1;
            int k = n - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target){
                    return target;
                }
                int diff = Math.abs(sum - target);
                if(diff < min){
                    min = diff;
                    ans = sum;
                }
                if(sum > target){
                    k --;
                }else{
                    j ++;
                }
            }
        }
        return ans;
    }
}