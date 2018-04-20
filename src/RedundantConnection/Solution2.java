class Solution2 {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[2001];
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }

        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            if(findParent(parent, a) == findParent(parent, b)){
                return new int[]{a, b};
            }else{
                parent[findParent(parent, a)] = findParent(parent, b);
            }
        }
        return new int[2];
    }

    private int findParent(int[] parent, int p){
        if(p != parent[p]){
            parent[p] = findParent(parent, parent[p]);
        }
        return parent[p];
    }
}