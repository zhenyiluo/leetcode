class Solution {
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0) return 0;
        int cnt = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int l = 1; l <= n; l++){
            for(int i = 0; i + l <= n; i++){
                int j = i + l - 1;
                if(s.charAt(i) == s.charAt(j) && (j -i <= 1 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    cnt ++;
                }
            }
        }
        return cnt;
    }
}