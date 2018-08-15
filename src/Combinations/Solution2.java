class Solution{
    public List<List<Integer>> combine(int n, int k){
        List<List<Integer>> ans = new ArrayList<>();
        if(n < 1) return ans;
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            list.add(i);
        }
        dfs(ans, list, new ArrayList<>(), 0, k);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> list, List<Integer> tmp, int start, int k){
        if(tmp.size() == k){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = start; i < list.size(); i++){
            tmp.add(list.get(i));
            dfs(ans, list, tmp, i+1, k);
            tmp.remove(tmp.size() -1);
        }
    }
}