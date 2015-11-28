import java.util.*;
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ret = new ArrayList<>();
        if(n == 1 ){
            ret.add(0);
            return ret;
        }

        HashMap<Integer, HashSet<Integer>> hm = buildMap(edges);

        List<Integer> leaves = new ArrayList<>();
        for(int key : hm.keySet()){
            if(hm.get(key).size() == 1){
                leaves.add(key);
            }
        }
        while(n > 2){
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int i : leaves){
                int j = hm.get(i).iterator().next();
                hm.get(j).remove(i);
                if(hm.get(j).size() == 1){
                    newLeaves.add(j);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }

    private HashMap<Integer, HashSet<Integer>> buildMap(int[][] edges){
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        int m = edges.length;
        for(int i = 0; i < m; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            if(!hm.containsKey(a)){
                hm.put(a, new HashSet<>());
            }
            hm.get(a).add(b);
            if(!hm.containsKey(b)){
                hm.put(b, new HashSet<>());
            }
            hm.get(b).add(a);
        }
        return hm;
    }
}