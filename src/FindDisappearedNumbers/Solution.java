class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if(nums == null || nums.length== 0) return ans;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] == i + 1) continue;
            int j = nums[i] -1;
            if(nums[j] == j + 1) continue;
            swap(nums, i, j);
            i--;
        }

        for(int i = 0; i < n; i++){
            if(nums[i] != i + 1){
                ans.add(i+1);
            }
        }
        return ans;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}