class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        dfs(ret, new ArrayList<>(), nums, 0);
        return ret;
    }

    private void dfs(List<List<Integer>> ret, List<Integer> tmpL, int[] nums, int start){
        ret.add(new ArrayList<>(tmpL));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue;
            tmpL.add(nums[i]);
            dfs(ret, tmpL, nums, i + 1);
            tmpL.remove(tmpL.size() -1);
        }
    }
}