class Solution {
    private static int[] dx = new int[]{-1, 1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int ret = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                ret = Math.max(ret, dfs(matrix, i, j, dp));
            }
        }
        return ret;
    }

    private int dfs(int[][] matrix, int x, int y, int[][] dp){
        if(dp[x][y] != 0) return dp[x][y];
        dp[x][y] = 1;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < dp.length && ny < dp[0].length && matrix[nx][ny] > matrix[x][y]){
                dp[x][y] = Math.max(dp[x][y], 1 + dfs(matrix, nx, ny, dp));
            }
        }
        return dp[x][y];
    }
}