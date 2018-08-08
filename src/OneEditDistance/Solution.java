class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null) return false;
        if(Math.abs(s.length() - t.length()) >= 2) return false;
        if(s.length() == t.length()){
            return isOneModify(s, t);
        }
        if(s.length() > t.length()){
            return isOneDelete(t, s);
        }else{
            return isOneDelete(s, t);
        }
    }

    private boolean isOneModify(String s, String t){
        int count = 0;
        for(int i = 0; i < s.length() ; i++){
            if(s.charAt(i) != t.charAt(i)){
                count ++;
            }
        }
        return count == 1;
    }

    private boolean isOneDelete(String s, String t){
        for(int i = 0, j = 0; i < s.length() && j < t.length(); i++, j++){
            if(s.charAt(i) != t.charAt(j)){
                return s.substring(i).equals(t.substring(j+1));
            }
        }
        return true;
    }
}