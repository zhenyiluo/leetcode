class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length == 0) return ans;
        List<Integer> list = new ArrayList<>();
        ans.add(list);
        for(int num: nums){
            int size = ans.size();
            for(int i = 0; i< size; i ++){
                List<Integer> tmp = new ArrayList<>(ans.get(i));
                tmp.add(num);
                ans.add(tmp);
            }
        }
        return ans;
    }
}