class Solution {
    public int numSimilarGroups(String[] A) {
        if(A == null || A.length == 0) return 0;

        int n = A.length;
        int ret = n;
        UF uf = new UF(n);
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(isSimiliar(A[i], A[j])){
                    ret -= uf.union(i, j);
                }
            }
        }
        return ret;
    }

    private boolean isSimiliar(String a, String b){
        int diff = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                diff++;
            }
        }
        return diff == 2 || diff == 0;
    }
}

class UF{
    int[] sz;
    int[] id;
    public UF(int n){
        sz = new int[n];
        id = new int[n];
        for(int i = 0; i < n; i++){
            sz[i] = 1;
            id[i] = i;
        }
    }

    public int union(int a, int b){
        int p = find(a);
        int q = find(b);
        if(p == q) return 0;
        if(sz[p] < sz[q]){
            sz[q] += sz[p];
            id[p] = q;
        }else{
            sz[p] += sz[q];
            id[q] = p;
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