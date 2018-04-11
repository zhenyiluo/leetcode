class Solution {
    public int findPairs(int[] nums, int k) {
        if(nums == null || nums.length <= 1 || k < 0) return 0;
        HashMap<Integer, Integer> hm = new HashMap();
        for(int num: nums){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        int ret = 0;
        for(int key: hm.keySet()){
            if(k == 0){
                if(hm.get(key) >= 2){
                    ret ++;
                }
            }else{
                if(hm.containsKey(key + k)){
                    ret ++;
                }
            }
        }
        return ret;
    }
}