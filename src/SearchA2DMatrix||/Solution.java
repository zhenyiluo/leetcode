public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int m = matrix.length; 
        int n = matrix[0].length;
        int x = 0; 
        int y = n-1;
        while(x < m && y >=0){
            if(target == matrix[x][y]){
                return true;
            }else if(target > matrix[x][y]){
                x++;
            }else{
                y--;
            }
        }
        return false;
    }
}