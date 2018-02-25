class NumMatrix1 {
    int[][] vals;
    int[][] tree;
    int m;
    int n;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        m = matrix.length;
        n = matrix[0].length;
        tree = new int[m+1][n+1];
        vals = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                update(i, j, matrix[i][j]);
            }
        }
    }
    public void update(int row, int col, int val) {
        int diff = val - vals[row][col];
        if(diff == 0){
            return;
        }
        vals[row][col] = val;
        for(int i = row+1; i <= m; i += i & (-i)){
            for(int j = col+1; j <= n; j+= j & (-j)){
                tree[i][j] += diff;
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum(row2+1, col2+1) + sum(row1, col1) - sum(row1, col2+1) - sum (row2+1, col1);
    }

    private int sum(int x, int y){
        int ret = 0;
        for(int i = x; i > 0; i -= i & (-i)){
            for(int j = y; j > 0; j-= j & (-j)){
                ret += tree[i][j];
            }
        }
        return ret;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */