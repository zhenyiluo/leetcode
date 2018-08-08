class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null) return false;
        int lenS = s.length();
        int lenT = t.length();
        if(Math.abs(lenS - lenT) >= 2) return false;
        if(lenS == lenT){
            int count = 0;
            for(int i = 0; i < lenS; i++){
                if(s.charAt(i) != t.charAt(i)){
                    count ++;
                }
            }
            return count == 1;
        }
        if(lenS > lenT){
            String tmp = s;
            s = t;
            t = tmp;
        }
        lenS = s.length();
        lenT = t.length();
        for(int i = 0, j = 0; i < lenS && j < lenT; i++, j++){
            if(s.charAt(i) != t.charAt(j)){
                return s.substring(i).equals(t.substring(j+1));
            }
        }
        return true;
    }
}