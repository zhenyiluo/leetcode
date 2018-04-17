class Solution {
    private static int[] dx = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
    private static int[] dy = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
    public int[][] imageSmoother(int[][] M) {
        if(M.length == 0 || M[0].length == 0) return new int[0][0];
        int m = M.length;
        int n = M[0].length;
        int[][] ret = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int sum = 0;
                int cnt = 0;
                for(int k = 0; k < 9; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(!isOutOfRange(nx, ny, M)){
                        sum += M[nx][ny];
                        cnt ++;
                    }
                }
                ret[i][j] = sum / cnt;
            }
        }
        return ret;
    }

    private boolean isOutOfRange(int x, int y, int[][] M){
        if(x < 0 || y < 0 || x >= M.length || y >= M[0].length) return true;
        return false;
    }
}