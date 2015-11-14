public class Solution2 {
    public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        
        HashSet<Character> hs = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            if(!hs.add(s.charAt(i))){
               hs.remove(s.charAt(i)); 
            }
        }
        return hs.size() <= 1;
    }
}