class Solution2 {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] sum = new int[len+1];
        for(int i = 0; i < len; i++){
            sum[i+1] = sum[i] + nums[i];
        }
        int ret = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++){
            int j = binarySearch(sum, i, s);
            if(j == Integer.MAX_VALUE) continue;
            if(j - i + 1 < ret){
                ret = j - i + 1;
            }
        }
        return ret == Integer.MAX_VALUE ? 0 : ret;
    }

    private int binarySearch(int[] sum, int i, int total){
        int j = sum.length - 2;
        int left = i;
        int ans = Integer.MAX_VALUE;
        while(i <= j){
            int mid = i + (j - i) / 2;
            if(sum[mid + 1] - sum[left] >= total){
                ans = mid;
                j = mid -1;
            }else{
                i = mid + 1;
            }
        }
        return ans;
    }
}