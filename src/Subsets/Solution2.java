class Solution2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if(nums == null || nums.length == 0) return ret;
        List<Integer> list = new ArrayList<>();
        dfs(ret, nums, 0, list);
        return ret;
    }

    private void dfs(List<List<Integer>> ret, int[] nums, int pos, List<Integer> list){
        if(pos == nums.length){
            ret.add(new ArrayList<>(list));
            return;
        }
        dfs(ret, nums, pos+1, list);
        list.add(nums[pos]);
        dfs(ret, nums, pos+1, list);
        list.remove(list.size() -1);
    }
}