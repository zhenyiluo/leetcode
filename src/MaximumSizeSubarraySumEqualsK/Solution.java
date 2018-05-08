class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        hm.put(sum, -1);
        int ret = 0;
        for(int i = 0 ; i< nums.length; i++){
            sum += nums[i];
            if(hm.containsKey(sum - k)){
                ret = Math.max(ret, i - hm.get(sum-k));
            }
            if(!hm.containsKey(sum)){
                hm.put(sum, i);
            }
        }
        return ret;
    }
}