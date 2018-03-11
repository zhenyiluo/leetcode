class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(ret, new ArrayList<>(), nums);
        return ret;
    }

    private void dfs(List<List<Integer>> ret, List<Integer> tmpL, int[] nums){
        if(tmpL.size() == nums.length){
            ret.add(new ArrayList<>(tmpL));
        }
        for(int i = 0; i < nums.length; i++){
            if(tmpL.contains(nums[i])) continue;
            tmpL.add(nums[i]);
            dfs(ret, tmpL, nums);
            tmpL.remove(tmpL.size() -1);
        }
    }
}