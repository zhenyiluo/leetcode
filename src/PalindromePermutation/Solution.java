public class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        
        HashMap<Character, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(hm.containsKey(c)){
                hm.put(c, hm.get(c)+1);
            }else{
                hm.put(c, 1);
            }
        }
        int count = 0;
        for(int n : hm.values()){
            if(n % 2 == 1){
                if(count == 1){
                    return false;
                }else{
                    count ++;
                }
            }
        }
        return true;
    }
}