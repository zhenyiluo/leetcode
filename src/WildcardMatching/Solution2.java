class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        int sIndex = 0;
        int pIndex = 0;
        int sMatch = 0;
        int pMatch = -1;
        int slen = s.length();
        int plen = p.length();
        while(sIndex < slen){
            if(pIndex < plen && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?')){
                sIndex++;
                pIndex++;
            }else if(pIndex < plen && p.charAt(pIndex) == '*'){
                sMatch = sIndex;
                pMatch = pIndex;
                pIndex++;
            }else if(pMatch != -1){
                pIndex = pMatch + 1;
                sMatch ++;
                sIndex = sMatch;
            }else return false;
        }
        while(pIndex < plen && p.charAt(pIndex) == '*') pIndex ++;
        return pIndex == plen;
    }
}