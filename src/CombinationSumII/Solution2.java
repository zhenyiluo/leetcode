class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return ans;
        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];
        dfs(ans, candidates, target, 0, visited, new ArrayList<>());
        return ans;
    }

    private void dfs(List<List<Integer>> ans, int[] candidates, int target, int start, boolean[] visited, ArrayList<Integer> list){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(i > 0 && candidates[i-1] == candidates[i] && !visited[i-1]) continue;
            if(target >= candidates[i]){
                visited[i] = true;
                list.add(candidates[i]);
                dfs(ans, candidates, target - candidates[i], i+1, visited, list);
                visited[i] = false;
                list.remove(list.size() -1);
            }
        }
    }
}