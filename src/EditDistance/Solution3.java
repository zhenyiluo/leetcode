class Solution {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null) return 0;
        if(word1.length() == 0) return word2.length();
        if(word2.length() == 0) return word1.length();
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = i + j;
                }else{
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                    }
                }
            }
        }
        return dp[m][n];
    }
}