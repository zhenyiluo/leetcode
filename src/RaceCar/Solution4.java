class Solution {
    public int racecar(int target) {
        HashSet<String> hs = new HashSet<>();
        String startKey = 0 + "#" + 1;
        hs.add(startKey);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 1});
        int level = -1;
        while(!q.isEmpty()){
            int size = q.size();
            level ++;
            for(int i = 0; i < size; i++){
                int[] key = q.poll();
                int pos = key[0];
                int speed = key[1];
                if(pos == target){
                    return level;
                }
                int pos1 = pos + speed;
                int speed1 = 2 * speed;
                String key1 = pos1 + "#" + speed1;
                int pos2 = pos;
                int speed2 = speed > 0 ? -1 : 1;
                String key2 = pos2 + "#" + speed2;
                if(Math.abs(pos1 - target) < target && !hs.contains(key1)){
                    hs.add(key1);
                    q.add(new int[]{pos1, speed1});
                }
                if(Math.abs(pos2 - target) < target && !hs.contains(key2)){
                    hs.add(key2);
                    q.add(new int[]{pos2, speed2});
                }
            }
        }
        return -1;
    }
}