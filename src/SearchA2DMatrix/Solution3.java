class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m * n - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(matrix[mid / n][mid % n] > target){
                end = mid - 1;
            }else if(matrix[mid / n][mid % n] < target){
                start = mid + 1;
            }else{
                return true;
            }
        }
        return false;
    }
}