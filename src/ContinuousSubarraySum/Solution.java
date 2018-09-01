class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length < 2) return false;
        int n = nums.length;
        int[] sum = new int[n+1];
        for(int i = 0; i < n; i++){
            sum[i+1] = sum[i] + nums[i];
        }
        for(int i = 0; i < n; i++){
            for(int j = i +1; j < n; j++){
                int tmp = getSum(sum, i, j);
                if(k == 0){
                    return tmp == 0;
                }else if(tmp % k == 0) return true;
            }
        }
        return false;
    }

    private int getSum(int[] sum, int i, int j){
        return sum[j+1] - sum[i];
    }
}