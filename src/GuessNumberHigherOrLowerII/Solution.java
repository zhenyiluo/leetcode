class Solution {
    public int getMoneyAmount(int n) {
        int[][] cache = new int[n+1][n+1];
        return dp(cache, 1, n);
    }

    private int dp(int[][] cache, int low, int high){
        if(low >= high) return 0;
        if(cache[low][high] != 0) return cache[low][high];
        int res = Integer.MAX_VALUE;
        for(int i = low; i <= high; i++){
            int tmp = i + Math.max(dp(cache, low, i-1), dp(cache, i+1, high));
            res = Math.min(res, tmp);
        }
        cache[low][high] = res;
        return res;
    }
}