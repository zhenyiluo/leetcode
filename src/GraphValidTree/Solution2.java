public class Solution2 {
    int[] id;
    int[] sz;
    public boolean validTree(int n, int[][] edges) {
        if(edges == null || edges.length == 0){
            return n == 1;
        }
        
        id = new int[n];
        sz = new int[n];
        
        for(int i = 0; i < n; i++){
            id[i] = i;
            sz[i] = 1;
        }
        int len = edges.length;
        for(int i = 0; i < len; i++){
            int p = find(edges[i][0]);
            int q = find(edges[i][1]);
            if(p == q){
                return false;
            }
            union(p, q);
        }
        
        return len +1 == n;
    }
    
    private int find(int x){
        while(x != id[x]){
            id[x] = id[id[x]];
            x = id[x];
        }
        return x;
    }
    
    private void union(int p, int q){
        if(sz[p] > sz[q]){
            sz[p] += sz[q];
            id[q] = p;
        }else{
            sz[q] += sz[p];
            id[p] = q;
        }
    }
}