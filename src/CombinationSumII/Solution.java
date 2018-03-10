class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(ret, new ArrayList<>(), candidates, target, 0);
        return ret;
    }

    private void dfs(List<List<Integer>> ret, List<Integer> tmp, int[] candidates, int target, int start){
        if(target < 0) return;
        if(target == 0){
            ret.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(i > start && candidates[i] == candidates[i-1]) continue;
            tmp.add(candidates[i]);
            dfs(ret, tmp, candidates, target - candidates[i], i+1);
            tmp.remove(tmp.size() -1);
        }
        return;
    }
}