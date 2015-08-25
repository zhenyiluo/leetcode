public class Solution {
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    public int numIslands(char[][] grid) {
        int ret = 0;
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return ret;
        }
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    ret ++;
                    check(i, j, grid);
                }
            }
        }
        return ret;
    }
    
    private void check(int x, int y, char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(x);
        q.add(y);
        grid[x][y] = '0';
        while(!q.isEmpty()){
            int tmpX = q.poll();
            int tmpY = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = tmpX + dx[i];
                int ny = tmpY + dy[i];
                if(nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] == '1'){
                    grid[nx][ny] = '0';
                    q.add(nx);
                    q.add(ny);
                }
            }
        }
    }
}