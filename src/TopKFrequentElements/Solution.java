class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        if(nums == null || nums.length == 0) return ans;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num : nums){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        for(int key: hm.keySet()){
            pq.add(new int[]{hm.get(key), key});
            if(pq.size() > k){
                pq.poll();
            }
        }
        while(!pq.isEmpty()){
            int[] pair = pq.poll();
            ans.add(pair[1]);
        }
        return ans;
    }
}