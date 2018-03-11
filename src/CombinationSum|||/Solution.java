class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<>();
        if(k <= 0 || n <= 0) return ret;
        dfs(ret, new ArrayList<>(), k, n, 1);
        return ret;
    }

    private void dfs(List<List<Integer>> ret, List<Integer> tmpL, int k, int n, int start){
        if(k== 0){
            if(n == 0){
                ret.add(new ArrayList<>(tmpL));
                return;
            }else{
                return;
            }
        }
        if(n < 0){
            return;
        }
        for(int i = start; i <= 9; i++){
            tmpL.add(i);
            dfs(ret, tmpL, k-1, n-i, i+1);
            tmpL.remove(tmpL.size() -1);
        }
    }
}