class SolutionNonDP {
    int lo = 0;
    int maxLen = 0;
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 2) return s;
        int len = s.length();
        for(int i = 0; i < len -1; i++){
            extend(s, i, i);
            extend(s, i, i+1);
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extend(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left --;
            right ++;
        }
        if(right - left -1 > maxLen){
            maxLen = right - left -1;
            lo = left + 1;
        }
    }
}