class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length ==0){
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] ret = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    ret[i][j] = grid[i][j];
                }else if(i == 0){
                    ret[i][j] = ret[i][j-1] + grid[i][j];
                }else if(j == 0){
                    ret[i][j] = ret[i-1][j] + grid[i][j];
                }else{
                    ret[i][j] = Math.min(ret[i-1][j], ret[i][j-1]) + grid[i][j];
                }
            }
        }
        return ret[m-1][n-1];
    }
}