public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] dp = new int[r][c];
        for(int i = 0; i < r; i++){
                if(matrix[i][0] == '1'){
                    dp[i][0] = 1;
                }
        }
        
        for(int j = 0; j < c; j++){
            if(matrix[0][j] == '1'){
                dp[0][j] = 1;
            }
        }
        int[][] v = new int[r][c];
        int[][] h = new int[r][c];
        for(int j = 0; j < c; j++){
            if(matrix[0][j] == '1'){
                h[0][j] = 1;
            }
        }
        for(int i = 1; i < r; i++){
            for(int j = 0; j < c; j++){
                if(matrix[i][j] == '1'){
                    h[i][j] = 1 + h[i-1][j];
                }else{
                    h[i][j] = 0;
                }
            }
        }
        
        for(int i = 0; i < r; i++){
            if(matrix[i][0] == '1'){
                v[i][0] = 1;
            }
        }
        for(int j = 1; j < c; j++){
            for(int i = 0; i < r; i++){
                if(matrix[i][j] == '1'){
                    v[i][j] = 1 + v[i][j-1];
                }else{
                    v[i][j] = 0;
                }
            }
        }
        
        for(int i = 1; i < r; i++){
            for(int j = 1; j < c; j++){
                if(matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }else{
                    int tmp = Math.min(v[i][j], h[i][j]);
                    dp[i][j] = Math.min(tmp, dp[i-1][j-1] + 1);
                }
            }
        }
        
        int maxVal = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c;j ++){
                maxVal= Math.max(maxVal, dp[i][j]);
            }
        }
        return maxVal * maxVal;
    }
}