class Solution {
    public static int M = 1000000007;
    public int countPalindromicSubsequences(String S) {
        if(S == null || S.length() == 0){
            return 0;
        }
        int len = S.length();
        int[][] dp = new int[len][len];
        for(int i = len-1; i >= 0; i--){
            dp[i][i] = 1;
            for(int j = i+1; j < len; j++){
                if(S.charAt(i) == S.charAt(j)){
                    int low = i+1;
                    int high = j-1;
                    while(low <= high && S.charAt(low) != S.charAt(i)){
                        low ++;
                    }
                    while(low <= high && S.charAt(high) != S.charAt(j)){
                        high --;
                    }
                    if(low > high){
                        dp[i][j] = dp[i+1][j-1] * 2 + 2;
                    }else if(low == high){
                        dp[i][j] = dp[i+1][j-1] * 2 + 1;
                    }else{
                        dp[i][j] = dp[i+1][j-1] * 2 - dp[low+1][high-1];
                    }
                }else{
                    dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1];
                }
                dp[i][j] = dp[i][j] < 0 ? dp[i][j] + M : dp[i][j] % M;
            }
        }
        return dp[0][len-1];
    }
}