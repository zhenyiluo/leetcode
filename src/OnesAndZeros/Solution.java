class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(String str: strs){
            int[] pair = getPair(str);
            for(int i = m ; i - pair[0] >= 0; i--){
                for(int j = n; j - pair[1] >= 0; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i-pair[0]][j-pair[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int[] getPair(String str){
        int x = 0;
        int y = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '0'){
                x++;
            }else if(str.charAt(i) == '1'){
                y++;
            }
        }
        return new int[]{x, y};
    }
}