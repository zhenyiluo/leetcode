class Solution {
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length < 2) return false;
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        HashSet<Integer> hs = new HashSet<>();
        hs.add(0);
        for(int num: nums){
            HashSet<Integer> tmp = new HashSet<>();
            for(int prev: hs){
                if(prev + num == target){
                    return true;
                }else if(prev + num < target){
                    tmp.add(prev+ num);
                }
            }
            hs.addAll(tmp);
        }
        return false;
    }
}