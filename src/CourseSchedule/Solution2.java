class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0) return false;
        int[] inDegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for(int[] pre : prerequisites){
            inDegree[pre[1]] ++;
        }
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int target = q.poll();
                for(int[] pre: prerequisites){
                    if(target == pre[0]){
                        inDegree[pre[1]] --;
                        if(inDegree[pre[1]] == 0){
                            q.add(pre[1]);
                        }
                    }
                }
            }
        }

        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] != 0){
                return false;
            }
        }
        return true;
    }
}