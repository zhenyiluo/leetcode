public class Solution1 {
    int[] id;
    int[] sz;
    private int find(int x){
        while(x != id[x]){
            id[x] = id[id[x]];
            x = id[x];
        }
        return x;
    }
    
    private void union(int p, int q){
        int i = find(p);
        int j = find(q);
        if(sz[i] < sz[j]){
            id[i] = j;
            sz[j] += sz[i];
        }else{
            id[j] = i;
            sz[i] += sz[j];
        }
    }
    
    private boolean isConnected(int p, int q){
        return find(p) == find(q);
    }
    
    public boolean validTree(int n, int[][] edges) {
        if(edges == null){
            return false;
        }
        
        id = new int[n];
        sz = new int[n];
        for(int i = 0; i < n; i++){
            id[i] = i;
            sz[i] = 1;
        }
        
        int m = edges.length;
        for(int i = 0; i < m; i++){
            int p = edges[i][0];
            int q = edges[i][1];
            if(isConnected(p, q)){
                return false;
            }
            union(p, q);
        }
        return m == n-1;
    }
}