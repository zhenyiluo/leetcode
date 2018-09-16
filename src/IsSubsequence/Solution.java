class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s == null || t == null) return false;
        return dfs(s, t);
    }

    private boolean dfs(String s, String t){
        if(s.length() == 0) return true;
        int j = 0;
        for(; j < t.length(); j ++){
            if(t.charAt(j) == s.charAt(0)) {
                if(dfs(s.substring(1), t.substring(j + 1))){
                    return true;
                }
            }
        }
        return false;
    }
}