class Solution {
    HashMap<String, Boolean> hm = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0) return true;
        if(hm.containsKey(s)) return hm.get(s);
        for(String word: wordDict){
            if(s.length() >= word.length() && s.startsWith(word)){
                if(wordBreak(s.substring(word.length()), wordDict)){
                    hm.put(s, true);
                    return true;
                }
            }
        }
        hm.put(s, false);
        return false;
    }
}