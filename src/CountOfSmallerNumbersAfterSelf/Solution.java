public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ret = new LinkedList<>();
        if(nums == null || nums.length == 0){
            return ret;
        }
        int len = nums.length;
        ArrayList<Integer> sorted = new ArrayList<>();
        for(int i = len -1; i>= 0; i--){
            int index = helper(sorted, nums[i]);
            ret.add(0, index);
            sorted.add(index, nums[i]);
        }
        return ret;
    }

    private int helper(ArrayList<Integer> sorted, int num){
        int low = 0;
        int high = sorted.size() - 1;
        while(low <= high){
            int mid = low + ((high - low) >> 1);
            if(sorted.get(mid) < num){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
}