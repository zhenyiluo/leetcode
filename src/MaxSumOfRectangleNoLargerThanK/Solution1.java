class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i< row; i++){
            int[] colSum = new int[col];
            for(int j = i; j< row; j++){
                for(int c = 0; c< col; c++){
                    colSum[c] += matrix[j][c];
                }
                max = Math.max(max, maxSumSubarray(colSum, k));
            }
        }
        return max;
    }

    private int maxSumSubarray(int[] nums, int k){
        int sum = 0;
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(0);
        int max = Integer.MIN_VALUE;
        for(int num: nums){
            sum += num;
            Integer prev = ts.ceiling(sum - k);
            if(prev != null) max = Math.max(max, sum - prev);
            ts.add(sum);
        }
        return max;
    }
}