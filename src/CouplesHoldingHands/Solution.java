class Solution {
    public int minSwapsCouples(int[] row) {
        int N = row.length / 2;
        UF uf = new UF(N);
        for(int i = 0; i < N; i++){
            int a = row[i * 2];
            int b = row[i * 2 + 1];
            uf.union(a/2, b/2);
        }
        return N - uf.count;
    }
}

class UF{
    int[] sz;
    int[] id;
    int count;
    public UF(int n){
        sz = new int[n];
        id = new int[n];
        for(int i = 0; i < n; i++){
            sz[i] = 1;
            id[i] = i;
        }
        count = n;
    }

    public void union(int a, int b){
        int p = find(a);
        int q = find(b);
        if(p == q) return;
        count --;
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