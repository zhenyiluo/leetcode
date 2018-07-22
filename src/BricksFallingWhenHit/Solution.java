class Solution {
    private static int[] dx = new int[]{-1, 1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] map = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = grid[i][j];
            }
        }
        for(int[] hit: hits){
            map[hit[0]][hit[1]] = 0;
        }

        UF uf = new UF(m * n + 1);

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 1){
                    if(i == 0){
                        uf.union(i * n + j, m * n);
                    }
                    if(i > 0 && map[i-1][j] == 1){
                        uf.union(i * n + j, (i-1) * n + j);
                    }
                    if(j > 0 && map[i][j-1] == 1){
                        uf.union(i* n + j, i * n + j -1);
                    }
                }
            }
        }

        int[] ret = new int[hits.length];

        for(int i = hits.length -1; i >= 0; i--){
            int[] hit = hits[i];
            int x = hit[0];
            int y = hit[1];
            int preCount = uf.top();
            if(grid[x][y] != 0){
                for(int k = 0; k < 4; k++){
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if(nx >= 0 && ny >= 0 && nx < m && ny < n && map[nx][ny] == 1){
                        uf.union(x * n + y, nx * n + ny);
                    }
                }
                if(x == 0){
                    uf.union(x * n + y, m * n);
                }
                map[x][y] = 1;
                ret[i] = Math.max(0, uf.top() - preCount - 1);
            }
        }
        return ret;
    }
}

class UF{
    int[] sz;
    int[] id;
    public UF(int n){
        sz = new int[n];
        id = new int[n];
        for(int i = 0; i < n; i++){
            sz[i] = 1;
            id[i] = i;
        }
    }

    public int top(){
        return sz[find(sz.length -1)];
    }

    public void union(int a, int b){
        int p = find(a);
        int q = find(b);
        if(p == q) return;
        if(sz[p] < sz[q]){
            sz[q] += sz[p];
            id[p] = q;
        }else{
            sz[p] += sz[q];
            id[q] = p;
        }
    }

    private int find(int i){
        while(i != id[i]){
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
}