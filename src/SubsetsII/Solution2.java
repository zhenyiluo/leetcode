class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return ans;
        }
        Arrays.sort(nums);
        dfs(ans, nums, 0, new ArrayList<>());
        return ans;
    }

    private void dfs(List<List<Integer>> ans, int[] nums, int start, List<Integer> list){
        ans.add(new ArrayList<>(list));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i-1] == nums[i]) continue;
            list.add(nums[i]);
            dfs(ans, nums, i+1, list);
            list.remove(list.size() -1);
        }
    }
}