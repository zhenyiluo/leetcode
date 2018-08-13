class Solution {
    public int calculate(String s) {
        char sign = '+';
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c= s.charAt(i);
            if(Character.isDigit(c)){
                int sum = c - '0';
                while(i+1 < s.length() && Character.isDigit(s.charAt(i+1))){
                    sum = sum * 10 + s.charAt(i+1) - '0';
                    i++;
                }
                pushToStack(sum, sign, st);
            }else if (c == '('){
                int cnt = 1;
                int j = i+1;
                while(j < s.length() && cnt != 0){
                    if(s.charAt(j) == ')'){
                        cnt --;
                    }else if(s.charAt(j) == '('){
                        cnt ++;
                    }
                    j++;
                }
                j--;
                int blockValue = calculate(s.substring(i+1, j));
                pushToStack(blockValue, sign, st);
                i = j;
            }else if(c != ' '){
                sign = c;
            }
        }
        int ans = 0;
        for(int val : st){
            ans += val;
        }
        return ans;
    }

    private void pushToStack(int val, char sign, Stack<Integer> st){
        if(sign == '+'){
            st.push(val);
        }else if(sign == '-'){
            st.push(-val);
        }else if(sign == '*'){
            st.push(st.pop() * val);
        }else if(sign == '/'){
            st.push(st.pop() / val);
        }
    }
}