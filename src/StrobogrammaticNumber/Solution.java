public class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0){
            return false;
        }
        int len = num.length();
        if(len % 2 != 0){
            char c = num.charAt(len/2);
            if(c != '1' && c != '8' && c != '0'){
                return false;
            }
        }
        
        for(int i = 0; i < len/2; i++){
            char c = num.charAt(i);
            char c1 = num.charAt(len-i-1);
            if(c == '1' || c == '8' || c == '0'){
                if(c1 != c){
                    return false;
                }
            }else if(c == '6'){
                if(c1 != '9'){
                    return false;
                }
            }else if(c == '9'){
                if(c1 != '6'){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}