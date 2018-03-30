class Solution2 {
    public int numDistinctIslands(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length ==0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        HashSet<List<List<Integer>>> vals = new HashSet<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    List<List<Integer>> val = new ArrayList<>();
                    dfs(grid, i, j, i, j, val);
                    vals.add(val);
                }
            }
        }
        return vals.size();
    }

    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};
    private void dfs(int[][] grid, int x0, int y0, int x, int y, List<List<Integer>> val){
        grid[x][y] = 0;
        val.add(Arrays.asList(x - x0, y - y0));
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] == 1){
                dfs(grid, x0, y0, nx, ny, val);
            }
        }
    }

}

