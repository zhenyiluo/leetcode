class Solution {
    public int racecar(int target) {
        HashSet<String> visited = new HashSet<>();
        visited.add(0 + "#" + 1);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 1});
        int level = -1;
        while(!q.isEmpty()){
            int size = q.size();
            level ++;
            for(int i = 0; i < size; i++){
                int[] pair = q.poll();
                int pos = pair[0];
                int speed = pair[1];
                if(pos == target){
                    return level;
                }
                int pos1 = pos + speed;
                int speed1 = speed * 2;
                String str1 = pos1 + "#" + speed1;
                int pos2 = pos;
                int speed2 = speed > 0 ? -1 : 1;
                String str2 = pos2 + "#" + speed2;
                if(Math.abs(pos1 - target) < target && !visited.contains(str1)){
                    visited.add(str1);
                    q.add(new int[]{pos1, speed1});
                }
                if(Math.abs(pos2 - target) < target && !visited.contains(str2)){
                    visited.add(str2);
                    q.add(new int[]{pos2, speed2});
                }
            }
        }
        return level;
    }
}