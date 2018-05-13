class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if(nums == null || nums.length == 0) return ret;
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(ret, nums, used, new ArrayList<>());
        return ret;
    }

    private void dfs(List<List<Integer>> ret, int[] nums, boolean[] used, List<Integer> list){
        if(list.size() == nums.length){
            ret.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            used[i] = true;
            list.add(nums[i]);
            dfs(ret, nums, used, list);
            list.remove(list.size() -1);
            used[i] = false;
        }
    }
}