class Solution {
    HashMap<String, List<String>> cache = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        if(cache.containsKey(s)){
            return cache.get(s);
        }
        List<String> res = new ArrayList<>();
        for(String prefix: wordDict){
            if(s.startsWith(prefix)){
                if(prefix.length() == s.length()){
                    res.add(prefix);
                    continue;
                }else{
                    List<String> strList = wordBreak(s.substring(prefix.length()), wordDict);
                    for(String str: strList){
                        res.add(prefix + " " + str);
                    }
                }
            }
        }
        cache.put(s, res);
        return res;
    }
}