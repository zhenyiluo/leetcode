class Solution {
    // left 0, down 1, right 2, up 3
    HashMap<String, Integer> cache = new HashMap<>();
    public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != '0') continue;
                int sum = 0;
                for(int k = 0; k < 4; k++){
                    sum += dfs(grid, i, j, k);
                }
                ans = Math.max(sum, ans);
            }
        }
        return ans;
    }

    private int dfs(char[][] grid, int x, int y, int dir){
        if(grid[x][y] == 'W') return 0;
        String key = x + "#" + y + "#" + dir;
        if(cache.containsKey(key)) return cache.get(key);
        int ans = 0;
        if(grid[x][y] == 'E') ans ++;
        if(dir == 0 && y -1 >= 0){
            ans += dfs(grid, x, y-1, dir);
        }else if(dir == 1 && x + 1 < grid.length){
            ans += dfs(grid, x+1, y, dir);
        }else if(dir == 2 && y + 1 < grid[0].length){
            ans += dfs(grid, x, y + 1, dir);
        }else if(dir == 3 && x - 1>= 0){
            ans += dfs(grid, x-1, y, dir);
        }
        cache.put(key, ans);
        return ans;
    }
}