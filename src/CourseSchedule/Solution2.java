class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0) return false;
        int[] degree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for(int[] pre : prerequisites){
            degree[pre[0]] ++;
        }
        for(int i = 0; i < numCourses; i++){
            if(degree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int target = q.poll();
                for(int[] pre: prerequisites){
                    if(target == pre[1]){
                        degree[pre[0]] --;
                        if(degree[pre[0]] == 0){
                            q.add(pre[0]);
                        }
                    }
                }
            }
        }

        for(int i = 0; i < numCourses; i++){
            if(degree[i] != 0){
                return false;
            }
        }
        return true;
    }
}