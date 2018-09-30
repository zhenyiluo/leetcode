class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        Stack<Integer> stInt = new Stack<>();
        Stack<String> stStr = new Stack<>();
        String num = "";
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num += c;
            }else if(c == '['){
                int val = Integer.valueOf(num);
                num = "";
                stInt.push(val);
                stStr.push(ans.toString());
                ans = new StringBuilder();
            }else if(c == ']'){
                String tmp = ans.toString();
                ans = new StringBuilder();
                int cnt = stInt.pop();
                ans.append(stStr.pop());
                for(int j = 0; j < cnt; j++){
                    ans.append(tmp);
                }
            }else{
                ans.append(c);
            }
        }
        return ans.toString();
    }
}