class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> st = new Stack<>();
        int sign = 1;
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            char c= s.charAt(i);
            if(Character.isDigit(c)){
                int sum = c - '0';
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i+1))){
                    sum = sum * 10 + s.charAt(i+1) - '0';
                    i++;
                }
                ans += sum * sign;
            }else if(c == '+'){
                sign = 1;
            }else if(c == '-'){
                sign = -1;
            }else if(c == '('){
                st.push(ans);
                st.push(sign);
                sign = 1;
                ans = 0;
            }else if(c == ')'){
                ans = ans * st.pop() + st.pop();
            }
        }
        return ans;
    }
}