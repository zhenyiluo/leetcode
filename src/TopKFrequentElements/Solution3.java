class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num: nums){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer>[] buckets = new ArrayList[nums.length + 1];
        for(int num: hm.keySet()){
            int val = hm.get(num);
            if(buckets[val] == null){
                buckets[val] = new ArrayList<>();
            }
            buckets[val].add(num);
        }
        int index = nums.length;
        while(k>0){
            if(buckets[index] != null){
                ArrayList<Integer> list = buckets[index];
                k -= list.size();
                for(int num: list){
                    ans.add(num);
                }
            }
            index--;
        }
        return ans;
    }
}