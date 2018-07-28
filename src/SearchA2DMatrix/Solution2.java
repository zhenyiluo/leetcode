class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m - 1;
        int targetRow = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(matrix[mid][0] > target){
                end = mid -1;
            }else if(matrix[mid][n-1] < target){
                start = mid + 1;
            }else{
                targetRow = mid;
                break;
            }
        }

        if(targetRow == -1) return false;

        int left = 0;
        int right = n -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(matrix[targetRow][mid] > target){
                right = mid - 1;
            }else if(matrix[targetRow][mid] < target){
                left = mid + 1;
            }else{
                return true;
            }
        }
        return false;
    }
}