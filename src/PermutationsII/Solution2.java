class Solution2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        HashSet<List<Integer>> retHs = new HashSet<>();
        if(nums == null || nums.length == 0) return ret;
        HashSet<Integer> hs = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        dfs(retHs, list, hs, nums);
        ret = new ArrayList<>(retHs);
        return ret;
    }

    private void dfs(HashSet<List<Integer>> retHs, List<Integer> list, HashSet<Integer> hs, int[] nums){
        if(hs.size() == nums.length){
            retHs.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!hs.contains(i)){
                hs.add(i);
                list.add(nums[i]);
                dfs(retHs, list, hs, nums);
                list.remove(list.size() -1);
                hs.remove(i);
            }
        }
    }
}