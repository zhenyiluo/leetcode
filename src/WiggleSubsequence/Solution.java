class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] large = new int[n];
        int[] small = new int[n];
        int ans = 0;
        for(int i = 0; i < n; i++){
            large[i] = 1;
            small[i] = 1;
        }
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(nums[i] < nums[j]){
                    if(large[j] < small[i] + 1){
                        large[j] = small[i] + 1;
                    }
                }else if(nums[i] > nums[j]){
                    if(small[j] < large[i] + 1){
                        small[j] = large[i] + 1;
                    }
                }
            }
        }
        for(int i = 0; i < n; i++){
            ans = Math.max(ans, Math.max(small[i], large[i]));
        }
        return ans;
    }
}