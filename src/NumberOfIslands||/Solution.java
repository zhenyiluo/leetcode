import java.util.*;
public class Solution {
    static int[] id;
    static int[] sz;
    static boolean[][] visited;
    public static int find(int x){
        while(x != id[x]){
            id[x] = id[id[x]];
            x = id[x];
        }
        return x;
    }

    public static void union(int p, int q){
        int i = find(p);
        int j = find(q);
        if(i == j){
            return ;
        }
        if(sz[i] < sz[j]){
            id[i] = j;
            sz[j] += sz[i];
        }else{
            id[j] = i;
            sz[i] += sz[j];
        }
    }
    public static final int[] dx = {-1, 1, 0, 0};
    public static final int[] dy = {0, 0, 1, -1};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        // Write your code here
        List<Integer> ret = new LinkedList<Integer>();
        if(positions == null || positions.length == 0){
            return ret;
        }
        id = new int[n * m];
        sz = new int[n * m];
        for(int i = 0; i < n * m; i++){
            id[i] = i;
            sz[i] = 1;
        }

        int cnt = 0;
        int len = positions.length;
        visited = new boolean[m][n];
        for(int i = 0; i < len; i++){
            int x = positions[i][0];
            int y = positions[i][1];
            if(visited[x][y]){
                ret.add(cnt);
                continue;
            }
            cnt++;
            visited[x][y] = true;
            int p = find(x * n + y);
            for(int j = 0; j < 4; j++){
                int nx = x + dx[j];
                int ny = y + dy[j];
                if(nx >= 0 && ny >= 0 && nx < m && ny < n && visited[nx][ny]){
                    int q = find(nx * n + ny);
                    if(p != q){
                        cnt --;
                        union(p, q);
                        p = find(x * n + y);
                    }
                }
            }
            ret.add(cnt);
        }
        return ret;
    }
}