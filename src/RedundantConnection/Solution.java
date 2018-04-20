class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];
            if(!graph.containsKey(a)){
                graph.put(a, new HashSet<>());
            }
            if(!graph.containsKey(b)){
                graph.put(b, new HashSet<>());
            }
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int size = edges.length;
        for(int i = size - 1; i >=0; i--){
            int a = edges[i][0];
            int b = edges[i][1];
            graph.get(a).remove(b);
            graph.get(b).remove(a);
            HashSet<Integer> visited = new HashSet<>();
            visited.add(a);
            if(isConnected(graph, a, b, visited)){
                return new int[]{a, b};
            }
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        return new int[]{-1, -1};
    }

    private boolean isConnected(HashMap<Integer, HashSet<Integer>> graph, int src, int dst, HashSet<Integer> visited){
        HashSet<Integer> srcConnected = graph.get(src);
        for(int next: srcConnected){
            if(visited.contains(next)) continue;
            if(next == dst) return true;
            visited.add(next);
            if(isConnected(graph, next, dst, visited)){
                return true;
            }
        }
        return false;
    }
}