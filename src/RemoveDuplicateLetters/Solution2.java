public class Solution2 {
    public String removeDuplicateLetters(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        
        Stack<Character> st = new Stack<>();
        int[] cnt = new int[26];
        boolean[] isExist = new boolean[26];
        for(int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']--;
            if(isExist[s.charAt(i) - 'a']) {
                continue;
            }
            while(!st.isEmpty() && s.charAt(i) < st.peek() && cnt[st.peek() - 'a'] != 0) {
                isExist[st.pop() - 'a'] = false;
            } 
            st.push(s.charAt(i));
            isExist[s.charAt(i) - 'a'] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        
        return sb.reverse().toString();
    }
}