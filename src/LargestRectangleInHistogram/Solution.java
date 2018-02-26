class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int max = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i <= len; i++){
            int h = (i == len ? -1 : heights[i]);
            if(st.isEmpty() || h >= heights[st.peek()]){
                st.push(i);
            }else{
                int top = st.pop();
                max = Math.max(max, heights[top] * (st.isEmpty() ? i : i - st.peek() -1));
                i --;
            }
        }
        return max;
    }
}