class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if(nums == null || nums.length == 0) return ans;
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] back = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = 1;
            back[i] = -1;
        }
        int max = 0;
        int maxIndex = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(nums[j] % nums[i] == 0){
                    if(dp[j] < dp[i] + 1){
                        dp[j] = dp[i] + 1;
                        if(max < dp[j]){
                            max = dp[j];
                            maxIndex = j;
                        }
                        back[j] = i;
                    }
                }
            }
        }

        while(maxIndex != -1){
            ans.add(nums[maxIndex]);
            maxIndex = back[maxIndex];
        }
        return ans;
    }
}