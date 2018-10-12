class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0) return true;
        if(prerequisites == null || prerequisites.length == 0) return true;
        int n = numCourses;
        HashSet<Integer>[] g = new HashSet[n];
        int[] indegree = new int[n];
        for(int[] pair : prerequisites){
            if(g[pair[0]] == null){
                g[pair[0]] = new HashSet<>();
            }
            g[pair[0]].add(pair[1]);
            indegree[pair[1]] ++;
        }
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;
        for(int i = 0; i< n; i++){
            if(indegree[i] == 0){
                q.add(i);
                cnt ++;
            }
        }

        while(!q.isEmpty()){
            int node1 = q.poll();
            if(g[node1] == null) continue;
            for(int node2 : g[node1]){
                indegree[node2] --;
                if(indegree[node2] == 0){
                    q.add(node2);
                    cnt ++;
                }
            }
        }

        return cnt == n;
    }
}