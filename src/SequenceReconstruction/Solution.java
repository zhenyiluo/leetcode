class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if(org == null || org.length == 0 || seqs == null || seqs.isEmpty()) return false;
        HashMap<Integer, Integer> degree = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for(List<Integer> seq: seqs){
            if(seq.size() >= 2){
                for(int i = 1; i < seq.size(); i++){
                    if(!graph.containsKey(seq.get(i-1))){
                        graph.put(seq.get(i-1), new HashSet<>());
                    }
                    graph.get(seq.get(i-1)).add(seq.get(i));
                }
            }else if(seq.size() == 1){
                if(!degree.containsKey(seq.get(0))){
                    degree.put(seq.get(0), 0);
                }
            }
        }
        for(int key: graph.keySet()){
            if(!degree.containsKey(key)){
                degree.put(key, 0);
            }
            for(int val: graph.get(key)){
                degree.put(val, degree.getOrDefault(val, 0) + 1);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int key: degree.keySet()){
            if(degree.get(key) == 0) q.add(key);
        }
        ArrayList<Integer> order = new ArrayList<>();
        while(!q.isEmpty()){
            if(q.size() > 1) return false;
            int key = q.poll();
            order.add(key);
            if(graph.containsKey(key)){
                for(int target: graph.get(key)){
                    degree.put(target, degree.get(target) -1);
                    if(degree.get(target) == 0){
                        q.add(target);
                    }
                }
                graph.remove(key);
            }
        }
        for(int key: degree.keySet()){
            if(degree.get(key) != 0) return false;
        }
        if(org.length != order.size()) return false;
        for(int i = 0; i < org.length; i++){
            if(org[i] != order.get(i)) return false;
        }
        return true;
    }
}