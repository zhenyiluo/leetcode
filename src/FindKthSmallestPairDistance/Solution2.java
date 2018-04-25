class Solution2 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0;
        int n = nums.length;
        int high = nums[n -1] - nums[0];
        while(low < high){
            int mid = low + (high - low) / 2;
            int cnt = 0;
            for(int i = 0; i < n -1; i ++){
                int j = i + 1;
                while(j < n && nums[j] - nums[i] <= mid) j ++;
                cnt += j - i -1;
            }
            if(cnt < k){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }
}