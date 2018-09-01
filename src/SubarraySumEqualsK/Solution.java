class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        int sum = 0;
        int ans = 0;
        for(int num: nums){
            sum += num;
            int otherKey = sum - k;
            ans += hm.getOrDefault(otherKey, 0);
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}