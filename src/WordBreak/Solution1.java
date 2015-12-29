public class Solution1 {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for(int i = 0; i < len; i++){
            if(!dp[i]){
                continue;
            }
            for(int j = i+1; j <= len; j++){
                if(wordDict.contains(s.substring(i, j))) {
                    dp[j] = true;
                }
            }
        }
        return dp[len];
    }
}