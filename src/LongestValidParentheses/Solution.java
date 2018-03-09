class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int max = 0;
        int left = -1;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }else{
                if(st.isEmpty()){
                    left = i;
                }else{
                    st.pop();
                    if(st.isEmpty()){
                        max = Math.max(max, i - left);
                    }else{
                        max = Math.max(max, i - st.peek());
                    }
                }
            }
        }
        return max;
    }
}