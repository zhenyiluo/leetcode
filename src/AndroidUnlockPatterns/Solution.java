class Solution {
    int ret = 0;
    public int numberOfPatterns(int m, int n) {
        boolean[][] visited = new boolean[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3;j ++){
                visited[i][j] = true;
                dfs(i, j, m, n, visited, 1);
                visited[i][j] = false;
            }
        }
        return ret;
    }

    private void dfs(int x, int y, int m, int n, boolean[][] visited, int step){
        if(step > n) return;
        if(step >= m && step <= n){
            ret ++;
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i == x && j == y) continue;
                if(visited[i][j]) continue;
                int diffx = Math.abs(i - x);
                int diffy = Math.abs(j - y);
                if((diffx * diffy == 0 && diffx + diffy ==2) || (diffx * diffy == 4)){
                    int midx = (i + x) /2;
                    int midy = (j + y) /2;
                    if(!visited[midx][midy]){
                        continue;
                    }
                }
                visited[i][j] = true;
                dfs(i, j, m, n, visited, step+1);
                visited[i][j] = false;
            }
        }
    }
}