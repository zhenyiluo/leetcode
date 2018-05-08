class Solution {
    public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0) return false;
        int j = s.length() -1;
        int i = 0;
        while(i < j){
            if(s.charAt(i++) == s.charAt(j--)) continue;
            if(i> j) return true;
            i--;
            j++;
            if(isValidPalindrome(s, i+1, j) || isValidPalindrome(s, i, j-1)){
                return true;
            }else{
                return false;
            }
        }
        return true;
    }

    private boolean isValidPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}