import java.util.*;
public class Solution {
    HashMap<Character, String> hm = new HashMap<>();
    HashSet<String> hs = new HashSet<>();
    public boolean wordPatternMatch(String pattern, String str) {
        if(pattern.length() == 0){
            return str.length() == 0;
        }
        
        char c = pattern.charAt(0);
        if(hm.containsKey(c)){
            String tmp = hm.get(c);
            if(tmp.length() > str.length() || !tmp.equals(str.substring(0, tmp.length()))){
                return false;
            }
            if(wordPatternMatch(pattern.substring(1), str.substring(tmp.length()))){
                return true;
            }
        }else{
            for(int i = 1; i <= str.length(); i++){
                String tmp = str.substring(0, i);
                if(hs.contains(tmp)){
                    continue;
                }
                hs.add(tmp);
                hm.put(pattern.charAt(0), tmp);
                if(wordPatternMatch(pattern.substring(1), str.substring(i))){
                    return true;
                }
                hm.remove(pattern.charAt(0));
                hs.remove(tmp);
            }
        }
        return false;
    }
}