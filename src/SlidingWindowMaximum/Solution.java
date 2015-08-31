public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k < 1 || nums == null || nums.length < 1){
            return new int[0];
        }
        int[] ret = new int[nums.length - k + 1];
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i = 0; i < nums.length; i++){
            while(!list.isEmpty() && nums[i] >= nums[list.getLast()]){
                list.removeLast();
            }
            list.addLast(i);
            if(i - list.getFirst() + 1 > k){
                list.removeFirst();
            }
            if(i + 1 >=k){
                ret[i+1 -k] = nums[list.getFirst()];
            }
        }
        return ret;
    }
}