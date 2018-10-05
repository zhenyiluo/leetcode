class Solution {
    public int minCut(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        int[] minPal = new int[n+1];
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++){
            minPal[i] = n;
        }

        for(int i = n-1; i >= 0; i --){
            for(int j = i; j < n; j++){
                if((s.charAt(i) == s.charAt(j)) && (j - i < 2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    minPal[i] = Math.min(minPal[i], 1 + minPal[j+1]);
                }
            }
        }
        return minPal[0] - 1;
    }
}