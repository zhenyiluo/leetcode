public class Solution1 {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a'] ++;
        }
        
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) {
                pos = i;
            }
            if(--cnt[s.charAt(i) - 'a'] == 0) {
                break;
            }
        }
        
        return s.charAt(pos) + removeDuplicateLetters(s.substring(pos+1).replaceAll("" + s.charAt(pos) , ""));
    }
}