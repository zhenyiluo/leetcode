public class Solution {
    HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if(!hm.containsKey(s)){
            if(s == null || s.length() == 0){
                List<String> list = new LinkedList<String>();
                list.add("");
                hm.put(s, list);
                return hm.get(s);
            }
            List<String> list = new LinkedList<String>();
            for(String prefix : wordDict){
                if(s.length() >= prefix.length() && s.substring(0, prefix.length()).equals(prefix)){
                    for(String tmpS : wordBreak(s.substring(prefix.length()), wordDict)){
                        if(tmpS.length() == 0){
                            list.add(prefix);
                        }else{
                            list.add(prefix + " " + tmpS);
                        }
                    }
                }
            }
            hm.put(s, list);
        }
        return hm.get(s);
    }
}