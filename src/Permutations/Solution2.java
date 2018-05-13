class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        dfs(ret, list, hs, nums);
        return ret;
    }

    private void dfs(List<List<Integer>> ret, List<Integer> list, HashSet<Integer> hs, int[] nums){
        if(hs.size() == nums.length){
            ret.add(new ArrayList<>(list));
        }
        for(int i = 0; i < nums.length; i++){
            if(!hs.contains(nums[i])){
                list.add(nums[i]);
                hs.add(nums[i]);
                dfs(ret, list, hs, nums);
                hs.remove(nums[i]);
                list.remove(list.size() -1);
            }
        }
    }
}