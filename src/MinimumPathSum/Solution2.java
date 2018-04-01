class Solution2 {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[2][n];
        dp[0][0] = grid[0][0];
        for(int i = 0 ; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0) continue;
                if(i == 0 || j== 0){
                    if(i == 0){
                        dp[0][j] = dp[0][j-1] + grid[0][j];
                    }else{
                        dp[i%2][0] = dp[(i-1)%2][0] + grid[i][0];
                    }
                }else{
                    dp[i%2][j] = grid[i][j] + Math.min(dp[(i-1)%2][j], dp[i%2][j-1]);
                }
            }
        }
        return dp[(m-1)%2][n-1];
    }
}