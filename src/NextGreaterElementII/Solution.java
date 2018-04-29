class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) return new int[0];
        int n = nums.length;
        int[] ret = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i >= 0; i--){
            st.push(i);
        }

        for(int i = n-1; i>= 0; i--){
            ret[i] = -1;
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                ret[i] = nums[st.peek()];
            }
            st.push(i);
        }
        return ret;
    }
}