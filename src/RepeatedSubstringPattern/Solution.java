class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s == null || s.length() <= 1) return false;
        int len = s.length();
        for(int i = 1; i <= len/2; i++){
            if(len % i != 0) continue;
            String cmp = s.substring(0, i);
            boolean flag = true;
            for(int j = 0; j <= len - i; j += i){
                if(!s.substring(j, j+i).equals(cmp)){
                    flag = false;
                }
            }
            if(flag) {
                return true;
            }
        }
        return false;
    }
}