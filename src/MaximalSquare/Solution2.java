class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int ret = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[2][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    dp[i%2][j] = matrix[i][j] == '1' ? 1: 0;
                }else if(matrix[i][j] == '1'){
                    dp[i%2][j] = Math.min(dp[(i-1)%2][j-1], Math.min(dp[(i-1)%2][j], dp[i%2][j-1])) + 1;
                }else{
                    dp[i%2][j] = 0;
                }
                ret = Math.max(ret, dp[i%2][j]);
            }
        }
        return ret * ret;
    }
}