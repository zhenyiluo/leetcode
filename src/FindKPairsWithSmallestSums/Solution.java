class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ret = new ArrayList<>();
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return ret;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]));
        for(int i = 0; i < nums1.length; i++){
            pq.add(new int[]{i, 0});
        }
        while(k > 0 && !pq.isEmpty()){
            int[] pair = pq.poll();
            int x = pair[0];
            int y = pair[1];
            ret.add(new int[]{nums1[x], nums2[y]});
            if(y+1 < nums2.length){
                pq.add(new int[]{x, y+1});
            }
            k--;
        }
        return ret;
    }
}