public class Solution {
    public boolean validTree(int n, int[][] edges) {
     
        if(edges == null || edges.length == 0 || edges[0].length == 0){
            if(n == 1){
                return true;
            }else{
                return false;
            }
        }
        
        HashSet<Integer>[] g = new HashSet[n];
        for(int i = 0; i < n; i++){
            g[i] = new HashSet<Integer>();
        }
        
        int m = edges.length;
        for(int i = 0; i < m; i++){
            int x = edges[i][0];
            int y = edges[i][1];
            g[x].add(y);
            g[y].add(x);
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        HashSet<Integer> hs = new HashSet<Integer>();
        hs.add(0);
        while(!q.isEmpty()){
            int start = q.poll();
            HashSet<Integer> tmp = g[start];
            for(int end : tmp){
                if(hs.contains(end)){
                    return false;
                }else{
                    g[end].remove(start);
                    hs.add(end);
                    q.add(end);
                }
            }
        }
        return hs.size() == n;
    }
}