class Solution {
    public int countComponents(int n, int[][] edges) {
        if(n <= 0) return 0;
        int ans = 0;
        boolean[] visited = new boolean[n];
        HashSet<Integer>[] g = new HashSet[n];
        for(int i = 0; i < n; i++){
            g[i] = new HashSet<>();
        }
        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];
            g[a].add(b);
            g[b].add(a);
        }
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                ans++;
                dfs(i, visited, g);
            }
        }
        return ans;
    }

    private void dfs(int i, boolean[] visited, HashSet<Integer>[] g){
        visited[i] = true;
        for(int a: g[i]){
            if(!visited[a]){
                dfs(a, visited, g);
            }
        }
    }
}