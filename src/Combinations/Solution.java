class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            list.add(i);
        }
        dfs(ret, new ArrayList<>(), list, n, k, 0);
        return ret;
    }

    private void dfs(List<List<Integer>> ret, List<Integer> tmpL, ArrayList<Integer> list, int n, int k, int start){
        if(tmpL.size() == k){
            ret.add(new ArrayList<>(tmpL));
            return;
        }
        for(int i = start; i < n; i++){
            tmpL.add(list.get(i));
            dfs(ret, tmpL, list, n, k, i+1);
            tmpL.remove(tmpL.size() -1);
        }
    }
}