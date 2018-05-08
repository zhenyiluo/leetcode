class Solution2 {
    public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0) return false;
        int j = s.length() -1;
        int i = 0;
        while(i < j && s.charAt(i) == s.charAt(j)){
            i++;
            j--;
        }
        if(i >= j) return true;
        if(isValidPalindrome(s, i+1, j) || isValidPalindrome(s, i, j-1)){
            return true;
        }else{
            return false;
        }
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