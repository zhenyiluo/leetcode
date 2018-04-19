class Solution {
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

        for(String mid : graph.keySet()){
            for(String src : graph.get(mid).keySet()){
                for(String dst : graph.get(mid).keySet()){
                    double newDst = graph.get(src).get(mid) * graph.get(mid).get(dst);
                    graph.get(src).put(dst, newDst);
                }
            }
        }

        int size = queries.length;
        double[] ret = new double[size];
        for(int i = 0; i < size; i++){
            String[] query = queries[i];
            String src = query[0];
            String dst = query[1];
            if(!graph.containsKey(src)){
                ret[i] = -1.0;
            }else{
                ret[i] = graph.get(src).getOrDefault(dst, -1.0);
            }
        }
        return ret;
    }
}