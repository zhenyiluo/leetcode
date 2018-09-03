class Solution {
    HashMap<String, List<String>> hm = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        if(hm.containsKey(s)){
            return hm.get(s);
        }
        List<String> ans = new ArrayList<>();
        if(s.length() == 0){
            ans.add("");
            hm.put(s, ans);
            return ans;
        }
        for(String word: wordDict){
            if(s.length() >= word.length() && s.startsWith(word)){
                List<String> tmpList = wordBreak(s.substring(word.length()), wordDict);
                for(String tmp: tmpList){
                    if(tmp.length() == 0){
                        tmp = word;
                    }else{
                        tmp = word + " " + tmp;
                    }
                    ans.add(tmp);
                }
            }
        }
        hm.put(s, ans);
        return ans;
    }
}