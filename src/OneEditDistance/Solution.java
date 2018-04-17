class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(Math.abs(s.length() - t.length()) > 1) return false;
        if(s.length() == t.length()) return isOneModify(s, t);
        if(s.length() > t.length()){
            return isOneDelete(s, t);
        }else{
            return isOneDelete(t, s);
        }
    }

    private boolean isOneModify(String s, String t){
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != t.charAt(i)){
                cnt ++;
            }
        }
        return cnt == 1;
    }

    private boolean isOneDelete(String s, String t){
        for(int i = 0, j = 0; i < s.length() && j < t.length(); i++, j++){
            if(s.charAt(i) != t.charAt(j)){
                return s.substring(i+1).equals(t.substring(j));
            }
        }
        return true;
    }
}