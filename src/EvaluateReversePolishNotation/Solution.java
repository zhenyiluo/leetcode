public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0){
            return 0;            
        }
        Stack<Integer> st = new Stack<>();
        int len = tokens.length;
        for(int i = 0; i < len; i++){
            String s = tokens[i];
            if(("+-*/").indexOf(s) != -1){
                int op2 = st.pop();
                int op1 = st.pop();
                if(s.equals("+")){
                    st.push(op1 + op2);
                }else if(s.equals("-")){
                    st.push(op1 - op2);
                }else if(s.equals("*")){
                    st.push(op1 * op2);
                }else{
                    st.push(op1 / op2);
                }
            }else{
                st.push(Integer.valueOf(s));
            }
        }
        return st.pop();
    }
}