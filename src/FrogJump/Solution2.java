class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(stones[i], new HashSet<>());
        }
        map.get(0).add(1);
        for(int i = 0; i < n-1; i ++){
            int stone = stones[i];
            for(int step: map.get(stone)){
                int reach = stone + step;
                if(reach == stones[n-1]) return true;
                if(map.containsKey(reach)){
                    HashSet<Integer> set = map.get(reach);
                    set.add(step);
                    set.add(step+1);
                    if(step -1 > 0){
                        set.add(step-1);
                    }
                }
            }
        }
        return false;
    }
}