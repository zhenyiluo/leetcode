class Solution {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int ret = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    ret ++;
                }
            }
        }
        return ret;
    }

    private void dfs(char[][] grid, int x, int y){
        grid[x][y] = '0';
        for(int i = 0; i < 4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if(nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] == '1'){
                dfs(grid, nx, ny);
            }
        }
    }
}