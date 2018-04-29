class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        int order = 0;
        int[] ret = new int[m*n];
        int idx = 0;
        for(int sum = 0; sum <= m+n -2; sum ++, order++){
            if(order %2 == 0){
                for(int j = 0; j <= sum && j < n; j++){
                    int i = sum - j;
                    if(i >= m) continue;
                    ret[idx++] = matrix[i][j];
                }
            }else{
                for(int i = 0; i <= sum && i < m; i++){
                    int j = sum - i;
                    if(j >= n) continue;
                    ret[idx++] = matrix[i][j];
                }
            }
        }
        return ret;
    }
}