class Solution {
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};
    public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2) return 0;
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            visited[i][0] = true;
            visited[i][n-1] = true;
            pq.add(new int[]{i, 0, heightMap[i][0]});
            pq.add(new int[]{i, n-1, heightMap[i][n-1]});
        }
        for(int j = 1; j < n-1; j++){
            visited[0][j] = true;
            visited[m-1][j] = true;
            pq.add(new int[]{0, j, heightMap[0][j]});
            pq.add(new int[]{m-1, j, heightMap[m-1][j]});
        }
        int ans = 0;
        while(!pq.isEmpty()){
            int[] tube = pq.poll();
            for(int i = 0; i < 4; i++){
                int nx = tube[0] + dx[i];
                int ny = tube[1] + dy[i];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    ans += Math.max(0, tube[2] - heightMap[nx][ny]);
                    pq.add(new int[]{nx, ny, Math.max(tube[2], heightMap[nx][ny])});
                }
            }
        }
        return ans;
    }
}