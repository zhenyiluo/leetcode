import java.math.BigInteger;
public class Solution1 {
    public boolean isAdditiveNumber(String num) {
        if(num == null || num.length() < 3){
            return false;
        }

        int len = num.length();
        for(int i = 1; i <= len/3; i++){
            if(i > 1 && num.charAt(0) == '0'){
                break;
            }
            BigInteger x1 = new BigInteger(num.substring(0, i));
            for(int j = 1; Math.max(i, j) <= len-i-j; j++){
                if(j > 1 && num.charAt(i) == '0'){
                    break;
                }
                BigInteger x2 = new BigInteger(num.substring(i, i+ j));
                if(helper(x1, x2, i+j, num)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(BigInteger val1, BigInteger val2, int start, String str){
        if(start == str.length()){
            return true;
        }
        val2 = val2.add(val1);
        val1 = val2.subtract(val1);
        String pre = val2.toString();
        return str.startsWith(pre, start) && helper(val1, val2, start + pre.length(), str);
    }
}