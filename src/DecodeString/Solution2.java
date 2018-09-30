class Solution {
    int pos = 0;
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        String num = "";
        for(int i = pos; i < s.length(); i++){
            char c = s.charAt(i);
            if(!Character.isDigit(c) && c != '[' && c != ']'){
                sb.append(c);
            }else if(Character.isDigit(c)){
                num += c;
            }else if(c == '['){
                int cnt = Integer.valueOf(num);
                num = "";
                pos = i + 1;
                String sub = decodeString(s);
                for(int j = 0; j < cnt; j++){
                    sb.append(sub);
                }
                i = pos;
            }else if(c == ']'){
                pos = i;
                return sb.toString();
            }
        }
        return sb.toString();
    }
}