class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int N = flights.length;
        int K = days[0].length;
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for(int i = 0; i < K; i++){
            int[] tmp = new int[N];
            Arrays.fill(tmp, Integer.MIN_VALUE);
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    if(j == k || flights[k][j] == 1){
                        tmp[j] = Math.max(tmp[j], dp[k] + days[j][i]);
                    }
                }
            }
            dp = tmp;
        }
        int ret = 0;
        for(int val: dp){
            ret = Math.max(ret, val);
        }
        return ret;
    }
}