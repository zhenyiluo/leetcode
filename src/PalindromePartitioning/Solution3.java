class Solution {
    boolean[][] dp;
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        int n = s.length();
        dp = new boolean[n][n];
        for(int i = n-1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if((s.charAt(i) == s.charAt(j)) && (j - i < 2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                }
            }
        }

        return dfs(s, 0);
    }

    private List<List<String>> dfs(String s, int start){
        List<List<String>> ans = new ArrayList<>();
        if(start == s.length()){
            ans.add(new ArrayList<>());
            return ans;
        }
        for(int i = start; i < s.length(); i++){
            if(dp[start][i]){
                for(List<String> list : dfs(s, i + 1)){
                    list.add(0, s.substring(start, i+1));
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}