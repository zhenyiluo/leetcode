class Solution {
    public int swimInWater(int[][] grid) {
        HashMap<Integer, ArrayList<int[]>> hm = new HashMap<>();
        int N = grid.length;
        for(int i = 0; i < N-1; i++){
            for(int j = 0; j < N; j++){
                int diff = Math.max(grid[i][j], grid[i+1][j]);
                if(!hm.containsKey(diff)){
                    hm.put(diff, new ArrayList<>());
                }
                int a = i * N + j;
                int b = (i+1) * N + j;
                hm.get(diff).add(new int[]{a, b});
            }
        }

        for(int j = 0; j < N -1; j++){
            for(int i = 0; i < N; i++){
                int diff = Math.max(grid[i][j], grid[i][j+1]);
                if(!hm.containsKey(diff)){
                    hm.put(diff, new ArrayList<>());
                }
                int a = i * N + j;
                int b = i * N + j + 1;
                hm.get(diff).add(new int[]{a, b});
            }
        }
        UF uf = new UF(N* N);
        for(int i = 0; i < N * N; i++){
            if(!hm.containsKey(i)) continue;
            for(int[] pair: hm.get(i)){
                int a = pair[0];
                int b = pair[1];
                uf.union(a, b);
            }
            if(uf.find(0) == uf.find(N * N -1)){
                return i;
            }
        }
        return N * N;
    }
}

class UF{
    int[] sz;
    int[] id;
    public UF(int n){
        sz = new int[n];
        id = new int[n];
        for(int i = 0; i < n; i++){
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int find(int i){
        while(i != id[i]){
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public void union(int a, int b){
        int p = find(a);
        int q = find(b);
        if(p == q) return;
        if(sz[p] < sz[q]){
            sz[q] += sz[p];
            id[p] = q;
        }else{
            sz[p] += sz[q];
            id[q] = p;
        }
    }
}