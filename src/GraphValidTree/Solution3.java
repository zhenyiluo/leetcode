class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n <= 0 || edges.length != n-1) return false;
        UF uf = new UF(n);
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            if(uf.find(a) == uf.find(b)){
                return false;
            }
            uf.union(a, b);
        }
        return true;
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
        if(p == q) return;
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