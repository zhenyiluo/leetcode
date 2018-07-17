class Solution {
    private static final int[] dx = new int[]{-1, 1, 0, 0};
    private static final int[] dy = new int[]{0, 0, -1 ,1};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ret = new LinkedList<>();
        if(m <= 0 || n <= 0 || positions == null || positions.length == 0){
            return ret;
        }
        UF uf = new UF(m * n);
        int count = 0;
        boolean[][] grid = new boolean[m][n];
        for(int[] position : positions){
            int x = position[0];
            int y = position[1];
            grid[x][y] = true;
            count ++;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny]){
                    count -= uf.union(n * x + y, n * nx + ny);
                }
            }
            ret.add(count);
        }
        return ret;
    }
}

class UF{
    int[] id;
    int[] sz;
    public UF(int n){
        id = new int[n];
        sz = new int[n];
        for(int i = 0; i < n; i++){
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int union(int p, int q){
        int a = find(p);
        int b = find(q);
        if(a == b) return 0;
        if(sz[a] < sz[b]){
            id[a] = b;
            sz[b] += sz[a];
        }else{
            id[b] = a;
            sz[a] += sz[b];
        }
        return 1;
    }

    private int find(int i){
        while(i != id[i]){
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
}