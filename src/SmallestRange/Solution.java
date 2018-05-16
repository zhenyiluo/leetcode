class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        if(nums == null || nums.isEmpty()) return new int[2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.size(); i++){
            pq.add(new int[]{nums.get(i).get(0), i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }
        int[] ret = new int[]{pq.peek()[0], max};
        while(true){
            int[] cur = pq.poll();
            int row = cur[1];
            int idx = cur[2];
            if(ret[1] - ret[0] == 0) break;
            if(idx + 1 == nums.get(row).size()) break;
            pq.add(new int[]{nums.get(row).get(idx+1), row, idx + 1});
            max = Math.max(max, nums.get(row).get(idx+1));
            if(max - pq.peek()[0] < ret[1] - ret[0]){
                ret[1] = max;
                ret[0] = pq.peek()[0];
            }
        }
        return ret;
    }
}