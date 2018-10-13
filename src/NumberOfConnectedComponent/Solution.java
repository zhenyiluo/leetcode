class Solution {
    public int countComponents(int n, int[][] edges) {
        if(n <= 0) return 0;
        int ans = n;
        UF uf = new UF(n);
        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];
            ans -= uf.union(a, b);
        }
        return ans;
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

    public int union(int a, int b){
        int p = parent(a);
        int q = parent(b);
        if(p == q) return 0;
        if(size[p] < size[q]){
            size[q] += size[p];
            id[p] = q;
        }else{
            size[p] += size[q];
            id[q] = p;
        }
        return 1;
    }

    private int parent(int i){
        while(i != id[i]){
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
}