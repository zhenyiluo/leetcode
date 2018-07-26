class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> ret = new ArrayList<>();
        if(buildings == null || buildings.length == 0){
            return ret;
        }
        int len = buildings.length;
        List<int[]> pairs = new ArrayList<>();
        for(int[] building: buildings){
            int left = building[0];
            int right = building[1];
            int height = building[2];
            pairs.add(new int[]{left, -height});
            pairs.add(new int[]{right, height});
        }
        Collections.sort(pairs, (p1, p2) -> {
            if(p1[0] == p2[0]){
                return p1[1] - p2[1];
            }else{
                return p1[0] - p2[0];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(10, (a, b) -> (b - a));
        pq.offer(0);
        int prev = 0;
        for(int[] pair: pairs){
            if(pair[1] < 0){
                pq.offer(-pair[1]);
            }else{
                pq.remove(pair[1]);
            }
            int cur = pq.peek();
            if(prev != cur){
                ret.add(new int[]{pair[0], cur});
                prev = cur;
            }
        }
        return ret;
    }
}