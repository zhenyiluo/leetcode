public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k < 0 || t < 0 || nums == null || nums.length < 1){
            return false;
        }
        TreeSet<Integer> ts = new TreeSet<Integer>();
        for(int i = 0; i< nums.length; i++){
            if(i >= k+1){
                ts.remove(nums[i-k-1]);
            }
            long left = (long) nums[i] - t;
            left = Math.max(left, Integer.MIN_VALUE);
            
            long right = (long) nums[i] + t;
            right = Math.min(right, Integer.MAX_VALUE);
            if(ts.subSet((int) left, true, (int) right, true).size() != 0){
                return true;                
            }else{
                ts.add(nums[i]);
            }
        }
        return false;
    }
}