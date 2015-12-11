public class Solution {
    public boolean isAdditiveNumber(String num) {
        if(num == null || num.length() < 3){
            return false;
        }

        int len = num.length();
        for(int i = 0; i < len-2; i++){
            for(int j = i+1; j < len -1; j++){
                String part1 = num.substring(0, i+1);
                String part2 = num.substring(i+1, j+1);
                if((part1.charAt(0) == '0' && part1.length() > 1) || (part2.charAt(0) == '0' && part2.length() > 1)){
                    continue;
                }

                long num1 = Long.valueOf(part1);
                long num2 = Long.valueOf(part2);

                long num3 = num1 + num2;
                String tmp = String.valueOf(num3);
                int len3 = tmp.length();
                String part3 = num.substring(j+1);
                if(part3.length() < len3 || !part3.substring(0, len3).equals(tmp)){
                    continue;
                }

                if(helper(num2, num3, part3.substring(len3))){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(long val1, long val2, String str){
        if(str.length() == 0){
            return true;
        }

        long tmp = val1 + val2;
        String s = String.valueOf(tmp);
        if(str.length() < s.length() || !str.substring(0, s.length()).equals(s)){
            return false;
        }else{
            return helper(val2, tmp, str.substring(s.length()));
        }
    }
}