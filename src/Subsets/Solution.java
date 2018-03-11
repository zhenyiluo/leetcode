class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(ret, new ArrayList<>(), nums, 0);
        return ret;
    }

    private void dfs(List<List<Integer>> ret, List<Integer> tmpL, int[] nums, int start){
        ret.add(new ArrayList<>(tmpL));
        for(int i = start; i < nums.length; i++){
            tmpL.add(nums[i]);
            dfs(ret, tmpL, nums, i + 1);
            tmpL.remove(tmpL.size() -1);
        }
    }
}