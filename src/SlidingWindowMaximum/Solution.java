class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k <= 0) return new int[0];
        int n = nums.length;
        int[] ret = new int[n - k + 1];
        int index = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(!list.isEmpty() && list.getFirst() < i - k + 1){
                list.removeFirst();
            }

            while(!list.isEmpty() && nums[list.getLast()] < nums[i]){
                list.removeLast();
            }

            list.add(i);

            if(i + 1 >= k){
                ret[index++] = nums[list.getFirst()];
            }
        }
        return ret;
    }
}