class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ret = "";
        int maxLen = 0;

        for(int L = 1; L <= n; L++){
            for(int i = 0; i + L <= n; i++){
                int j = i + L -1;
                if(s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i+ 1][j-1])){
                    dp[i][j] = true;
                    if(j - i +1 > maxLen){
                        maxLen = j - i + 1;
                        ret = s.substring(i, j + 1);
                    }
                }
            }
        }
        return ret;
    }
}