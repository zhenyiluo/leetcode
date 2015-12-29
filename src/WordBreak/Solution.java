public class Solution {
    HashMap<String, Boolean> cache = new HashMap<>();
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0){
            return true;
        }
        if(cache.containsKey(s)){
            return cache.get(s);
        }
        for(int i = 1; i <= s.length(); i++){
            if(wordDict.contains(s.substring(0, i))){
                if(wordBreak(s.substring(i), wordDict)){
                    cache.put(s, true);
                    return true;
                }
            }
        }
        cache.put(s, false);
        return false;
    }
}