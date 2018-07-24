class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return ret;
        }
        ArrayList<Integer> sortList = new ArrayList<>();
        for(int i = nums.length -1; i >= 0; i--){
            int index = helper(sortList, nums[i]);
            ret.add(0, index);
            sortList.add(index, nums[i]);
        }
        return ret;
    }

    private int helper(ArrayList<Integer> sortList, int target){
        int left = 0;
        int right = sortList.size() - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(sortList.get(mid) < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
}