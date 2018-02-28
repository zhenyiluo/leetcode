class Solution {
    public int myAtoi(String str) {
        if(str == null) return 0;
        long ret = 0;
        boolean negative = false;

        str = str.trim();

        if(str.length() == 0){
            return 0;
        }

        char first = str.charAt(0);

        if((first >= '0' && first <= '9') || first == '+' || first == '-'){
            if(first == '-'){
                negative = true;
            }
            if(first == '-' || first == '+'){
                str = str.substring(1);
            }
            ret = parse(str);
        }else{
            return 0;
        }

        if(negative){
            ret = - ret;
        }

        if(ret < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        if(ret > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        return (int) ret;
    }

    private long parse(String s){
        long ret = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c < '0' || c > '9'){
                break;
            }
            ret = ret * 10 + (c - '0');
            if(ret > ((long) Integer.MAX_VALUE + 1)){
                return ret;
            }
        }
        return ret;
    }
}