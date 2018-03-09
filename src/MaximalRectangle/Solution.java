class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n];
        int ret = 0;
        for(char[] row : matrix){
            for(int i = 0; i < n; i++){
                if(row[i] == '1'){
                    heights[i] ++;
                }else{
                    heights[i] = 0;
                }
            }

            ret = Math.max(ret, maxArea(heights));
        }
        return ret;
    }

    private int maxArea(int[] heights){
        int max = 0;
        Stack<Integer> st = new Stack<>();
        int len = heights.length;

        for(int i = 0; i <= len; i++){
            int h = (i == len ? -1 : heights[i]);
            if(st.isEmpty() || h >= heights[st.peek()]){
                st.push(i);
            }else{
                int top = st.pop();
                max = Math.max(max, heights[top] * (st.isEmpty() ? i : i - st.peek() -1));
                i--;
            }
        }
        return max;
    }
}