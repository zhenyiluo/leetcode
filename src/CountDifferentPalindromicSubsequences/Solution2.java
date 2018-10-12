class Solution {
    private static final int MOD = (int)1e9 + 7;
    TreeSet<Integer>[] ts;
    public int countPalindromicSubsequences(String S) {
        if(S == null || S.length() == 0) return 0;
        ts = new TreeSet[4];
        for(int i = 0; i < 4; i++){
            ts[i] = new TreeSet<>();
        }
        for(int i = 0; i< S.length(); i++){
            int index = S.charAt(i) - 'a';
            ts[index].add(i);
        }
        int[][] dp = new int[S.length()][S.length()];
        return dfs(dp, 0, S.length() -1, ts);
    }

    private int dfs(int[][] dp, int start, int end, TreeSet<Integer>[] ts){
        if(start > end) return 0;
        if(dp[start][end] != 0) return dp[start][end];
        long ans = 0;
        for(int i = 0; i < 4; i++){
            Integer nextStart = ts[i].ceiling(start);
            Integer nextEnd = ts[i].floor(end);
            if(nextStart == null || nextEnd == null || nextStart > end) continue;
            ans++;
            if(nextStart != nextEnd){
                ans ++;
            }
            ans += dfs(dp, nextStart + 1, nextEnd - 1, ts);
        }
        ans = ans % MOD;
        dp[start][end] = (int) ans;
        return dp[start][end];
    }
}