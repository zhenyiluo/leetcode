import java.math.BigInteger;
public class Solution2 {
    public boolean isAdditiveNumber(String num) {
        if(num == null || num.length() < 3){
            return false;
        }

        int len = num.length();
        for(int i = 1; i <= len/3; i++){
            if(i > 1 && num.charAt(0) == '0'){
                break;
            }
            for(int j = 1; Math.max(i, j) <= len-i-j; j++){
                if(helper(i, j, num)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(int i, int j, String str){
        if(str.charAt(i) == '0' && j > 1){
            return false;
        }
        String sum;
        BigInteger x1 = new BigInteger(str.substring(0, i));
        BigInteger x2 = new BigInteger(str.substring(i, i+ j));
        for(int start = i+j; start != str.length(); start += sum.length()){
            x2 = x2.add(x1);
            x1 = x2.subtract(x1);
            sum = x2.toString();
            if(!str.startsWith(sum, start)){
                return false;
            }
        }
        return true;
    }
}