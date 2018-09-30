class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        int firstDigitPos = getFirstDigitPos(s);
        if(firstDigitPos == s.length()) return s;
        if(firstDigitPos > 0){
            sb.append(s.substring(0, firstDigitPos));
        }
        int num = getFirstNum(s, firstDigitPos);
        int start = s.indexOf('[');
        int cnt = 1;
        int end = start + 1;
        while(cnt != 0){
            if(s.charAt(end) == '['){
                cnt ++;
            }else if(s.charAt(end) == ']'){
                cnt --;
            }
            end ++;
        }
        String sub = decodeString(s.substring(start +1, end -1));
        for(int i = 0; i < num; i++){
            sb.append(sub);
        }
        sb.append(decodeString(s.substring(end)));
        return sb.toString();
    }

    private int getFirstNum(String s, int pos){
        int first = pos;
        int next = pos +1;
        while(next < s.length()){
            if(s.charAt(next) >= '0' && s.charAt(next) <= '9'){
                next++;
            }else{
                break;
            }
        }
        return Integer.valueOf(s.substring(first, next));
    }

    private int getFirstDigitPos(String s){
        int pos = 0;
        while(pos < s.length()){
            if(s.charAt(pos) >= '0' && s.charAt(pos) <= '9'){
                return pos;
            }
            pos ++;
        }
        return pos;
    }
}