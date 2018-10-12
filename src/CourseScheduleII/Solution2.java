class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        if(n <= 0) return new int[0];
        int[][] pre = prerequisites;
        HashSet<Integer>[] g = new HashSet[n];
        int[] indegree = new int[n];
        for(int[] pair : pre){
            if(g[pair[1]] == null){
                g[pair[1]] = new HashSet<>();
            }
            g[pair[1]].add(pair[0]);
            indegree[pair[0]] ++;
        }

        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int n1 = q.poll();
            ans.add(n1);
            if(g[n1] == null) continue;
            for(int n2: g[n1]){
                indegree[n2] --;
                if(indegree[n2] == 0){
                    q.add(n2);
                }
            }
        }
        if(ans.size() != n) return new int[0];
        int[] ret = new int[n];
        for(int i = 0; i < n; i++){
            ret[i] = ans.get(i);
        }
        return ret;
    }
}