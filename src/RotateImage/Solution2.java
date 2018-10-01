class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length <= 1) return;
        int n = matrix.length;
        for(int i = 0; i < n / 2; i ++){
            for(int j = 0; j < n; j++){
                swap(matrix, i, j, n - i - 1, j);
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                swap(matrix, i, j, j, i);
            }
        }
    }

    private void swap(int[][] matrix, int x1, int y1, int x2, int y2){
        int tmp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = tmp;
    }
}