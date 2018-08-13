class Solution {
    // + 1
    // - -1
    // * 3
    // / 4
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        int sign = 1;

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int sum = c - '0';
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i+1))){
                    sum = sum * 10 + s.charAt(i+1) - '0';
                    i++;
                }
                if(!st.isEmpty() && st.peek() >= 3){
                    int tmpSign = st.pop();
                    int val1 = st.pop();
                    if(tmpSign == 3){
                        st.push(val1 * sum);
                    }else if(tmpSign == 4){
                        st.push(val1 / sum);
                    }
                }else{
                    st.push(sum);
                }
            }else if(c == '+'){
                sign = 1;
                st.push(sign);
            }else if(c == '-'){
                sign = -1;
                st.push(sign);
            }else if(c == '*'){
                sign = 3;
                st.push(sign);
            }else if(c == '/'){
                sign = 4;
                st.push(sign);
            }
        }

        int ans = 0;
        Stack<Integer> st2 = new Stack<>();
        while(!st.isEmpty()){
            st2.push(st.pop());
        }
        st = st2;
        while(!st.isEmpty()){
            if(st.size() == 1){
                ans = st.pop();
            }else{
                int val1 = st.pop();
                int sign2 = st.pop();
                int val2 = st.pop();
                st.push(val1 + val2 * sign2);
            }
        }
        return ans;
    }
}