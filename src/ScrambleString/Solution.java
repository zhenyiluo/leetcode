public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1 == null || s2 == null){
            return false;
        }
        
        if(s1.length() != s2.length()){
            return false;
        }
        
        if(s1.equals(s2)){
            return true;
        }
        
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        
        if(!Arrays.equals(c1, c2)){
            return false;
        }
        
        for(int split = 1; split < s1.length(); split ++){
            String s1_first = s1.substring(0, split);
            String s1_second = s1.substring(split);
            String s2_first = s2.substring(0, split);
            String s2_second = s2.substring(split);
            if(isScramble(s1_first, s2_first) && isScramble(s1_second, s2_second)){
                return true;
            }
            s2_first = s2.substring(0, s1.length()- split);
            s2_second = s2.substring(s1.length() - split);
            if(isScramble(s1_first, s2_second) && isScramble(s1_second, s2_first)){
                return true;
            }
        }
        return false;
    }
}