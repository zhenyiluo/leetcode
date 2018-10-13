class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, nums, 0, new ArrayList<>());
        return ans;
    }

    private void dfs(List<List<Integer>> ans, int[] nums, int pos, List<Integer> list){
        if(pos == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        dfs(ans, nums, pos + 1, list);
        list.add(nums[pos]);
        dfs(ans, nums, pos + 1, list);
        list.remove(list.size() -1);
    }
}