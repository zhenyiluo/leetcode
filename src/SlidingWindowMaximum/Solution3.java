class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        int len = nums.length;
        int[] ans = new int[len - k + 1];
        int index = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < len; i++){
            if(!list.isEmpty() && list.getFirst() <= i - k){
                list.removeFirst();
            }

            while(!list.isEmpty() && nums[list.getLast()] < nums[i]){
                list.removeLast();
            }

            list.add(i);
            if(i >= k -1){
                ans[index++] = nums[list.getFirst()];
            }
        }
        return ans;
    }
}