class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        HashMap<Integer, int[]> hm = new HashMap<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                hm.put(grid[i][j], new int[]{i, j});
            }
        }
        UF uf = new UF(N * N);
        for(int i = 1; i < N * N; i++){
            int[] pos = hm.get(i);
            int x = pos[0];
            int y = pos[1];
            for(int j = 0; j < 4; j++){
                int nx = x + dx[j];
                int ny = y + dy[j];
                if(nx >= 0 && ny >= 0 && nx < N && ny < N && grid[x][y] > grid[nx][ny]){
                    uf.union(x * N + y, nx * N + ny);
                    if(uf.find(0) == uf.find(N * N -1)){
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}

class UF{
    int[] id;
    int[] size;
    public UF(int n){
        id = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            id[i] = i;
            size[i] = 1;
        }
    }

    public void union(int a, int b){
        int p = find(a);
        int q = find(b);
        if (p ==q) return;
        if(size[p] < size[q]){
            size[q] += size[p];
            id[p] = q;
        }else{
            size[p] += size[q];
            id[q] = p;
        }
    }

    public int find(int i){
        while(i != id[i]){
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
}