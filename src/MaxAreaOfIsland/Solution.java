class Solution {
    private static int[] dx = new int[]{-1, 1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    int[] cnt = new int[]{0};
                    dfs(grid, cnt, visited, i, j);
                    ans = Math.max(cnt[0], ans);
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, int[] cnt, boolean[][] visited, int x, int y){
        cnt[0] ++;
        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && !visited[nx][ny] && grid[nx][ny] == 1){
                dfs(grid, cnt, visited, nx, ny);
            }
        }
    }
}