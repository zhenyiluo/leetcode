class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];

        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] pre : prerequisites){
            graph[pre[0]].add(pre[1]);
        }

        boolean[] visited = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(!dfs(i, visited, graph)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, boolean[] visited, ArrayList<Integer>[] graph){
        if(visited[node]){
            return false;
        }
        visited[node] = true;

        for(int next : graph[node]){
            if(!dfs(next, visited, graph)){
                return false;
            }
        }
        visited[node] = false;
        return true;
    }
}