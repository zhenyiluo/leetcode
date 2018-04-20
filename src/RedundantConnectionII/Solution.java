class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] parent = new int[edges.length +1];
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
        int[] candidate1 = null;
        int[] candidate2 = null;
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            if(findParent(parent, a) == findParent(parent, b)){
                candidate2 = edge; // record last edge which results in "cycle" issue, if any.
            }else{
                if(findParent(parent, b) != b){
                    candidate1 = edge; // record the last edge which results in "multiple parents" issue
                }else{
                    parent[findParent(parent, b)] = findParent(parent, a);
                }
            }
        }
        if(candidate1 == null) return candidate2;
        if(candidate2 == null) return candidate1;
        for (int[] e : edges) if (e[1] == candidate1[1]) return e;
        return new int[2];
    }

    private int findParent(int[] parent, int p){
        if(p != parent[p]){
            parent[p] = findParent(parent, parent[p]);
            p = parent[p];
        }
        return parent[p];
    }
}