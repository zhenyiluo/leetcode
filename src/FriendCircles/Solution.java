class Solution {
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0 || M[0].length == 0 || M.length != M[0].length){
            return 0;
        }

        int N = M.length;
        UF uf = new UF(N);
        int ret = N;
        for(int i = 0; i< N; i++){
            for(int j = 0; j < i; j++){
                if(M[i][j] == 1){
                    ret -= uf.union(i, j);
                }
            }
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
        while(id[i] != i){
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
}