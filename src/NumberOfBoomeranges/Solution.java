class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if(points == null || points.length < 3) return 0;
        int len = points.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans = 0;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(i == j) continue;
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                int dist = dx * dx + dy * dy;
                hm.put(dist, hm.getOrDefault(dist, 0) + 1);
            }
            for(int val : hm.values()){
                ans += val * (val -1);
            }
            hm.clear();
        }
        return ans;
    }
}