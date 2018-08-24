class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        return maxSubArray(nums, 0, nums.length -1);
    }

    private int maxSubArray(int[] nums, int left, int right){
        if(left == right) return nums[left];
        int mid = left + (right - left) / 2;
        return Math.max(Math.max(maxSubArray(nums, left, mid), maxSubArray(nums, mid+1, right)),
                masCrossingSum(nums, left, right, mid));
    }

    private int masCrossingSum(int[] nums, int left, int right, int mid){
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = mid; i>= left; i--){
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for(int i = mid+1; i <= right; i++){
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }
        return leftSum + rightSum;
    }
}