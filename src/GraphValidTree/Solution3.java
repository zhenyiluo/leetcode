class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n < 0 || edges.length != n - 1){
            return false;
        }
        if(n == 0) return true;
        UF uf = new UF(n);
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            if(uf.union(a, b) == 0) return false;
        }
        return true;
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

    public int union(int a, int b){
        int p = find(a);
        int q = find(b);
        if(p == q) return 0;
        if(sz[p] < sz[q]){
            id[p] = q;
            sz[q] += sz[p];
        }else{
            id[q] = p;
            sz[p] += sz[q];
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