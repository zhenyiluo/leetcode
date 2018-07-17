class Solution {
    private static final int[] dx = new int[]{-1, 1, 0, 0};
    private static final int[] dy = new int[]{0, 0, -1, 1};
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int ret = 0;
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    ret ++;
                    bfs(grid, i, j);
                }
            }
        }
        return ret;
    }

    private void bfs(char[][] grid, int x, int y){
        grid[x][y] = '0';
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] pair = q.poll();
                for(int j = 0; j < 4; j++){
                    int nx = pair[0] + dx[j];
                    int ny = pair[1] + dy[j];
                    if(nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] == '1'){
                        grid[nx][ny] = '0';
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}