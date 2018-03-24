class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        if(forest == null || forest.isEmpty()) return 0;
        int ret = 0;
        int m = forest.size();
        int n = forest.get(0).size();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(forest.get(i).get(j) > 1){
                    pq.add(new int[]{i, j, forest.get(i).get(j)});
                }
            }
        }
        int[] start = new int[2];
        while(!pq.isEmpty()){
            int[] end = pq.poll();
            int step = helper(forest, m, n, start, end);
            if(step < 0) return -1;
            ret += step;
            start[0] = end[0];
            start[1] = end[1];
        }
        return ret;
    }
    private static int[] dx = new int[]{-1, 1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};
    private int helper(List<List<Integer>> forest, int m, int n, int[] start, int[] end){
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        int step = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int j = 0; j < size; j++){
                int[] tmp = q.poll();
                if(tmp[0] == end[0] && tmp[1] == end[1]) return step;
                for(int i = 0; i < 4; i++){
                    int x = tmp[0] + dx[i];
                    int y = tmp[1] + dy[i];
                    if(x >= 0 && y >= 0 && x < m && y < n && !visited[x][y] && forest.get(x).get(y) > 0){
                        q.add(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}