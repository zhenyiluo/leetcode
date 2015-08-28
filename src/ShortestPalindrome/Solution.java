public class Solution {

    public String shortestPalindrome(String s) {
        int j = 0; 
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) == s.charAt(j)){
                j++;
            }
        }
        if(j == s.length()){
            return s;
        }
        String suffix = s.substring(j);
        String prefix = new StringBuilder(suffix).reverse().toString();
        String mid = shortestPalindrome(s.substring(0, j));
        return prefix + mid + suffix;
    }

}