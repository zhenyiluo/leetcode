public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k < 1 || nums == null || nums.length < 1){
            return new int[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){
                return i2 - i1;
            }
        });
        for(int i = 0; i < k; i++){
            pq.add(nums[i]);
        }
        int[] ret = new int[nums.length - k + 1];
        ret[0] = pq.peek();
        for(int i = k ; i < nums.length; i++){
            pq.remove(nums[i - k]);
            pq.add(nums[i]);
            ret[i-k + 1] = pq.peek();
        }
        return ret;
    }
}