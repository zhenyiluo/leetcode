public class Solution {
    boolean[][] dp;
    public List<List<String>> partition(String s) {
        if(s == null){
            return null;
        }
        List<List<String>> ret = new ArrayList<List<String>>();
        if(s.length() == 0){
            return ret;
        }
        dp = new boolean[s.length()][s.length()];
        for(int i = s.length()-1; i>= 0; i--){
            for(int j = i; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j) && ((j - i < 2) || (dp[i+1][j-1]))){
                    dp[i][j] = true;
                }
            }
        }
        return dfs(s, 0);
    }
    
    public List<List<String>> dfs(String s, int start){
        List<List<String>> ret = new ArrayList<List<String>>();
        if(s.length() == start){
            ret.add(new ArrayList<String>());
            return ret;
        }
        for(int i = start; i < s.length(); i++){
            if(dp[start][i]){
                for(List<String> list : dfs(s, i+1)){
                    list.add(0, s.substring(start, i+1));
                    ret.add(list);
                }
            }
        }
        return ret;
    }
}