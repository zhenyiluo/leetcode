public class Solution {
    public String minWindow(String s, String t) {
        int[] needToFind = new int[256];
        int[] hasFound = new int[256];
        String ans = "";
        int minWin = Integer.MAX_VALUE;
        for(int i = 0; i < t.length(); i++) {
            needToFind[t.charAt(i)] ++;
        }
        
        int count = 0;
    
        for(int begin = 0, end = 0; end < s.length(); end ++) {
            char c = s.charAt(end);
            if(needToFind[c] == 0) {
                continue;
            }
            hasFound[c]++;
            if(hasFound[c] <= needToFind[c]) {
                count ++;
            }
            
            if(count == t.length()) {
                while(needToFind[s.charAt(begin)] == 0 || needToFind[s.charAt(begin)] < hasFound[s.charAt(begin)]){
                    if(needToFind[s.charAt(begin)] < hasFound[s.charAt(begin)]) {
                        hasFound[s.charAt(begin)] --;
                    }
                    begin ++;
                } 
                if(end - begin + 1 < minWin) {
                    minWin = end - begin + 1;
                    ans = s.substring(begin, end + 1);
                }
            }
        }
        return ans;
    }
}


