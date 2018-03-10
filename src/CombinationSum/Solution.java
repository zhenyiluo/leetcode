class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            tmp.add(candidates[i]);
            dfs(ret, tmp, candidates, target - candidates[i], i);
            tmp.remove(tmp.size() - 1);
        }
    }
}