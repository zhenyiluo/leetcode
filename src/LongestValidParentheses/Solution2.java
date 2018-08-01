class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        Stack<Integer> st = new Stack<>();
        int left = -1;
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }else{
                if(st.isEmpty()){
                    left = i;
                }else{
                    st.pop();
                    max = Math.max(max, i - (st.isEmpty() ? left : st.peek()));
                }
            }
        }
        return max;
    }
}