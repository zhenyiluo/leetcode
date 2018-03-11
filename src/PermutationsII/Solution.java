class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(ret, new ArrayList<>(), nums, used);
        return ret;
    }

    private void dfs(List<List<Integer>> ret, List<Integer> tmpL, int[] nums, boolean[] used){
        if(tmpL.size() == nums.length){
            ret.add(new ArrayList<>(tmpL));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            used[i] = true;
            tmpL.add(nums[i]);
            dfs(ret, tmpL, nums, used);
            used[i] = false;
            tmpL.remove(tmpL.size() -1);
        }
    }
}