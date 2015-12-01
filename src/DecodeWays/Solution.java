public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int len = s.length();
        int[] dp = new int[len+1];
        dp[len] = 1;
        
        for(int i = len-1; i>= 0; i--){
            if(s.charAt(i) == '0'){
                dp[i] = 0;
            }else if(i <= len-2 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6' ))){
                dp[i] = dp[i+1] + dp[i+2];
            }else{
                dp[i] = dp[i+1];
            }
        }
        
        return dp[0];
    }
}