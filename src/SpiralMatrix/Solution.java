class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return ret;
        int level = -1;
        int m = matrix.length;
        int n = matrix[0].length;
        while(true){
            level ++;
            int minI = level;
            int maxI = m - 1 - level;
            int minJ = level;
            int maxJ = n - 1 - level;
            if(minI > maxI || minJ > maxJ) break;
            helper(ret, minI, maxI, minJ, maxJ, matrix);
        }
        return ret;
    }

    private void helper(List<Integer> ret, int minI, int maxI, int minJ, int maxJ, int[][] matrix){
        for(int j = minJ; j <= maxJ; j ++){
            ret.add(matrix[minI][j]);
        }
        for(int i = minI + 1; i <= maxI; i++){
            ret.add(matrix[i][maxJ]);
        }
        if(minI != maxI){
            for(int j = maxJ -1; j >= minJ; j--){
                ret.add(matrix[maxI][j]);
            }
        }
        if(minJ != maxJ){
            for(int i = maxI - 1; i >= minI + 1; i--){
                ret.add(matrix[i][minJ]);
            }
        }
    }
}