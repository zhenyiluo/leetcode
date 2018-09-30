class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        if(nums == null || nums.length == 0) return ans;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num : nums){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer>[] buckets = new ArrayList[nums.length + 1];
        for(int key: hm.keySet()){
            int val = hm.get(key);
            if(buckets[val] == null){
                buckets[val] = new ArrayList<>();
            }
            buckets[val].add(key);
        }
        for(int i = nums.length; i >= 0 && k > 0; i--){
            if(buckets[i] != null){
                ArrayList<Integer> list = buckets[i];
                k -= list.size();
                for(int num: list){
                    ans.add(num);
                }
            }
        }
        return ans;
    }
}