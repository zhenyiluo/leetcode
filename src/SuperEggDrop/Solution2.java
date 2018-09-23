class Solution {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K+1][N+1];
        for(int j = 1; j <= N; j++){
            dp[1][j] = j;
        }
        for(int i = 1; i <= K; i++){
            dp[i][1] = 1;
        }
        for(int i = 2; i <= K; i++){
            for(int j = 2; j <= N; j++){
                int l = 1;
                int r = j;
                int result = Integer.MAX_VALUE;
                while(l <= r){
                    int mid = l + (r - l) / 2;
                    int left = dp[i-1][mid-1];
                    int right = dp[i][j - mid];
                    result = Math.min(result, 1 + Math.max(left, right));
                    if(left == right){
                        break;
                    }else if(left < right){
                        l = mid + 1;
                    }else{
                        r = mid -1;
                    }
                }
                dp[i][j] = result;
            }
        }
        return dp[K][N];
    }
}