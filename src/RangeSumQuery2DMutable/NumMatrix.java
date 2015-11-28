public class NumMatrix {
    int[][] matrix;
    int[][] sum;
    int m;
    int n;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        sum = new int[m+1][n];
        init();
    }

    public void update(int row, int col, int val) {
        int ori = matrix[row][col];
        int diff = val - ori;
        if(diff == 0){
            return;
        }
        for(int i = row +1; i<= m; i++){
            sum[i][col] += diff;
        }
        matrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ret = 0;
        for(int j = col1; j <= col2; j++){
            ret += sum[row2+1][j] - sum[row1][j];
        }
        return ret;
    }
    
    private void init(){
        for(int i = 1; i <= m; i++){
            for(int j = 0; j < n; j++){
                sum[i][j] = sum[i-1][j] + matrix[i-1][j];
            }
        }
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);