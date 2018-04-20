class Solution2 {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        for(int i = 0; i < equations.length; i++){
            String[] equation = equations[i];
            double value = values[i];
            String src = equation[0];
            String dst = equation[1];
            if(!graph.containsKey(src)){
                graph.put(src, new HashMap<>());
            }
            if(!graph.containsKey(dst)){
                graph.put(dst, new HashMap<>());
            }
            graph.get(src).put(src, 1.0);
            graph.get(src).put(dst, value);
            graph.get(dst).put(dst, 1.0);
            graph.get(dst).put(src, 1/value);
        }

        int size = queries.length;
        double[] ret = new double[size];
        for(int i = 0; i < size; i++){
            String[] query = queries[i];
            String src = query[0];
            String dst = query[1];
            if(!graph.containsKey(src)){
                ret[i] = -1.0;
            }else if(src.equals(dst)){
                ret[i] = 1.0;
            }else{
                HashSet<String> visited = new HashSet<>();
                visited.add(src);
                ret[i] = dfs(graph, src, dst, 1.0, visited);
            }
        }
        return ret;
    }

    private double dfs(HashMap<String, HashMap<String, Double>> graph, String src, String dst, double cur, HashSet<String> visited){
        HashMap<String, Double> srcConnected = graph.get(src);
        for(String next: srcConnected.keySet()){
            if(visited.contains(next)){
                continue;
            }
            if(dst.equals(next)){
                return cur * srcConnected.get(next);
            }
            visited.add(next);
            double tmp = dfs(graph, next, dst, cur * srcConnected.get(next), visited);
            if(tmp != -1.0){
                return tmp;
            }
        }
        return -1.0;
    }
}