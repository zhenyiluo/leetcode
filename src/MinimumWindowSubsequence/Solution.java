class Solution {
    public String minWindow(String S, String T) {
        int lenT = T.length();
        int lenS = S.length();
        int[][] dp = new int[lenT +1][lenS +1];
        for(int i = 0; i <= lenS; i++){
            dp[0][i] = i+1;
        }
        for(int i = 1; i<= lenT; i ++){
            for(int j = 1; j <= lenS; j++){
                if(T.charAt(i-1) == S.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int start = -1;
        for(int i = 1; i<= lenS; i++){
            if(dp[lenT][i] != 0){
                if(i - dp[lenT][i] + 1 < min){
                    min = i - dp[lenT][i] + 1;
                    start = dp[lenT][i] -1;
                }
            }
        }
        return start == -1 ? "" : S.substring(start, start + min);
    }
}