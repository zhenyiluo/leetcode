class Solution {
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new ArrayList<>();
        }
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] visited1 = new boolean[m][n];
        boolean[][] visited2 = new boolean[m][n];
        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        for(int i = 0; i < m; i++){
            visited1[i][0] = true;
            q1.add(new int[]{i, 0});
            visited2[i][n-1] = true;
            q2.add(new int[]{i, n-1});
        }
        for(int j = 0; j < n;j ++){
            visited1[0][j] = true;
            q1.add(new int[]{0, j});
            visited2[m-1][j] = true;
            q2.add(new int[]{m-1, j});
        }

        bfs(visited1, q1, matrix);
        bfs(visited2, q2, matrix);

        List<int[]> ret = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited1[i][j] && visited2[i][j]){
                    ret.add(new int[]{i, j});
                }
            }
        }
        return ret;
    }

    private void bfs(boolean[][] visited, Queue<int[]> q, int[][] matrix){
        while(!q.isEmpty()){
            int[] pair = q.poll();
            int x = pair[0];
            int y = pair[1];
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < matrix.length && ny < matrix[0].length && !visited[nx][ny] &&
                        matrix[nx][ny] >= matrix[x][y]){
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}