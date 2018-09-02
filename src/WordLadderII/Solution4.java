class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        HashSet<String> hs = new HashSet<>();
        for(String word: wordList){
            hs.add(word);
        }
        if(!hs.contains(endWord)){
            return ans;
        }
        Queue<String> q = new LinkedList<>();
        HashMap<String, List<String>> hm = new HashMap<>();
        q.add(beginWord);
        while(!q.isEmpty()){
            int size = q.size();
            HashSet<String> buffer = new HashSet<>();
            for(int i = 0; i < size; i++){
                String curWord = q.poll();
                if(!curWord.equals(endWord)){
                    StringBuilder sb = new StringBuilder(curWord);
                    for(int j = 0; j < curWord.length(); j++){
                        for(char c = 'a'; c <= 'z'; c++){
                            if(c != curWord.charAt(j)){
                                sb.setCharAt(j, c);
                                if(hs.contains(sb.toString())){
                                    buffer.add(sb.toString());
                                    if(!hm.containsKey(sb.toString())){
                                        hm.put(sb.toString(), new ArrayList<>());
                                    }
                                    hm.get(sb.toString()).add(curWord);
                                }
                            }
                        }
                        sb.setCharAt(j, curWord.charAt(j));
                    }
                }else{
                    ans = generateResult(beginWord, endWord, hm);
                    break;
                }
            }
            for(String word: buffer){
                q.add(word);
                hs.remove(word);
            }
        }
        return ans;
    }

    private List<List<String>> generateResult(String beginWord, String endWord, HashMap<String, List<String>> hm){
        List<List<String>> ans = new ArrayList<>();
        if(endWord.equals(beginWord)){
            List<String> tmp = new ArrayList<>();
            tmp.add(beginWord);
            ans.add(tmp);
            return ans;
        }
        for(String lastWord: hm.get(endWord)){
            List<List<String>> tmpList = generateResult(beginWord, lastWord, hm);
            for(List<String> list: tmpList){
                list.add(endWord);
                ans.add(list);
            }
        }
        return ans;
    }
}