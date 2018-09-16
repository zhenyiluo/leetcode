class Solution {
    private HashMap<Integer, Integer> cache = new HashMap<>();
    public int combinationSum4(int[] nums, int target) {
        if(target == 0) return 0;
        if(cache.containsKey(target)) return cache.get(target);
        int ans = 0;
        for(int num : nums){
            if(num < target){
                ans += combinationSum4(nums, target - num);
            }else if(num == target){
                ans += 1;
            }
        }
        cache.put(target, ans);
        return ans;
    }
}