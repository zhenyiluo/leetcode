class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ret = new int[numCourses];
        int[] degree = new int[numCourses];
        for(int[] pre: prerequisites){
            degree[pre[0]] ++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(degree[i] == 0){
                q.add(i);
            }
        }

        int index = -1;
        while(!q.isEmpty()){
            int target = q.poll();
            ret[++index] = target;
            for(int[] pre: prerequisites){
                if(target == pre[1]){
                    degree[pre[0]]--;
                    if(degree[pre[0]] == 0){
                        q.add(pre[0]);
                    }
                }
            }
        }
        if(index == numCourses -1){
            return ret;
        }else{
            return new int[0];
        }
    }
}