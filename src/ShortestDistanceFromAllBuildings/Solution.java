class Solution {

    private int min = Integer.MAX_VALUE;
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, 1, -1};
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        int level = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    bfs(grid, i, j, dist, --level);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void bfs(int[][] grid, int row, int col, int[][] dist, int level){
        min = Integer.MAX_VALUE;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        int step = 0;
        while(!q.isEmpty()){
            step ++;
            int size = q.size();
            for(int k = 0; k < size; k++ ){
                int[] node = q.poll();
                int x = node[0];
                int y = node[1];
                for(int i = 0; i < 4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] == level){
                        q.add(new int[]{nx, ny});
                        dist[nx][ny] += step;
                        min = Math.min(min, dist[nx][ny]);
                        grid[nx][ny] --;
                    }
                }
            }
        }
    }
}