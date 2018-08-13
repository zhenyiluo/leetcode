class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> st = new Stack<>();
        char sign = '+';
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int sum = s.charAt(i) - '0';
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i+1))){
                    sum = sum * 10 + s.charAt(i+1) - '0';
                    i++;
                }
                if(sign == '+'){
                    st.push(sum);
                }else if(sign == '-'){
                    st.push(-sum);
                }else if(sign == '*'){
                    st.push(st.pop() * sum);
                }else if(sign == '/'){
                    st.push(st.pop() / sum);
                }
            }else if(c == '+'){
                sign = '+';
            }else if(c == '-'){
                sign = '-';
            }else if(c == '*'){
                sign = '*';
            }else if(c == '/'){
                sign = '/';
            }
        }
        int ans = 0;
        for(int val : st){
            ans += val;
        }
        return ans;
    }
}