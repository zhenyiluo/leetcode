class Solution {
    static int MOD = (int) Math.pow(10, 9) + 7;
    public int numDecodings(String s) {
        if(s == null) return 0;
        int len = s.length();
        long[] dp = new long[len +1];
        dp[len] = 1;
        for(int i = s.length() -1; i >= 0; i--){
            if(s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            if(s.charAt(i) == '*'){
                dp[i] += 9 * dp[i+1];
            }else{
                dp[i] += dp[i+1];
            }
            if(i < s.length() -1){
                if(s.charAt(i) == '*' && s.charAt(i+1) == '*'){
                    dp[i] += 15 * dp[i+2];
                }else if(s.charAt(i) == '*'){
                    dp[i] += dp[i+2];
                    if(s.charAt(i+1) <= '6'){
                        dp[i] += dp[i+2];
                    }
                }else if(s.charAt(i+1) == '*'){
                    if(s.charAt(i) == '1'){
                        dp[i] += 9 * dp[i+2];
                    }else if(s.charAt(i) == '2'){
                        dp[i] += 6 * dp[i+2];
                    }
                }else{
                    int val = Integer.valueOf(s.substring(i, i+2));
                    if(val >= 1 && val <= 26){
                        dp[i] += dp[i+2];
                    }
                }
            }
            dp[i] = dp[i] % MOD;
        }
        return (int) dp[0];
    }
}