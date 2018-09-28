class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s == null || t == null) return false;
        if(s.length() == 0) return true;
        if(t.length() == 0) return false;
        int indexS = 0;
        int indexT = 0;
        while(indexS < s.length() && indexT < t.length()){
            if(s.charAt(indexS) == t.charAt(indexT)){
                indexS++;
                indexT++;
            }else{
                indexT++;
            }
            if(indexS == s.length()) return true;
        }
        return false;
    }
}