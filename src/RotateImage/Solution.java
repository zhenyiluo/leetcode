class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        upDownFlip(matrix);
        diagonalFlip(matrix);
    }

    private void upDownFlip(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0; i < row/2; i++){
            for(int j = 0; j < col; j++){
                swap(matrix, i, j, row - i -1, j);
            }
        }
    }

    private void diagonalFlip(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0; i < row; i++){
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