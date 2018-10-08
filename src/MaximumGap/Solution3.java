class Solution {
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length <= 1) return 0;
        int m = 0;
        for(int num: nums){
            m = Math.max(num, m);
        }
        int exp = 1;
        int[] sort = new int[nums.length];
        while(m / exp > 0){
            int[] cnt = new int[10];
            for(int i = 0; i < nums.length; i++){
                cnt[(nums[i]/exp) % 10] ++;
            }
            for(int i = 1; i < 10; i++){
                cnt[i] += cnt[i-1];
            }
            for(int i = nums.length - 1; i >= 0; i--){
                sort[--cnt[(nums[i] / exp) % 10]] = nums[i];
            }

            for(int i = 0; i < nums.length; i++){
                nums[i] = sort[i];
            }
            exp *= 10;
        }
        int ans = 0;
        for(int i = 0; i < sort.length - 1; i++){
            ans = Math.max(sort[i+1] - sort[i], ans);
        }
        return ans;
    }
}