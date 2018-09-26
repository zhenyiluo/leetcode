class Solution {
    public int racecar(int target) {
        String key = 0 + "#" + 1;
        HashSet<String> hs = new HashSet<>();
        hs.add(key);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 1});
        int step = -1;
        while(!q.isEmpty()){
            int size = q.size();
            step ++;
            for(int i = 0; i < size; i++){
                int[] pair = q.poll();
                int pos = pair[0];
                int speed = pair[1];
                if(pos == target){
                    return step;
                }
                int pos1 = pos + speed;
                int speed1 = speed * 2;
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