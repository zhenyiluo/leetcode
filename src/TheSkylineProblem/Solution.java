import java.util.*;
public class Solution {
    static class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> ret = new LinkedList<int[]>();
        if(buildings == null || buildings.length == 0 || buildings[0].length == 0){
            return ret;
        }
        List<Pair> pairs = new ArrayList<Pair>();
        for(int[] building : buildings){
            pairs.add(new Pair(building[0], building[2]));
            pairs.add(new Pair(building[1], -building[2]));
        }
        Collections.sort(pairs, new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                if(p1.first != p2.first){
                    return p1.first - p2.first;
                }
                return p2.second - p1.second;
            }
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });
        int pre = 0;
        int cur = 0;
        for(int i = 0; i < pairs.size(); i++){
            Pair pair = pairs.get(i);
            if(pair.second > 0){
                pq.add(pair.second);
                cur = pq.peek();
            }else{
                pq.remove(-pair.second);
                if(pq.peek() != null){
                    cur = pq.peek();
                }else{
                    cur = 0;
                }
            }
            
            if(cur != pre){
                ret.add(new int[]{pair.first, cur});
                pre = cur;
            }
        }
        return ret;
    }
}