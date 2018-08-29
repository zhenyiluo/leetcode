class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        if(wordList == null || wordList.isEmpty()) return ans;
        HashSet<String> words = new HashSet<>();
        for(String word: wordList){
            words.add(word);
        }
        if(!words.contains(endWord)) return ans;
        HashMap<String, HashSet<String>> wordToParentsMapping = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        while(!q.isEmpty()){
            int size = q.size();
            HashSet<String> buf = new HashSet<>();
            for(int i = 0; i < size; i++){
                String word = q.poll();
                if(word.equals(endWord)){
                    ans = generateList(wordToParentsMapping, beginWord, endWord);
                    break;
                }
                StringBuilder sb = new StringBuilder(word);
                for(int j = 0; j < word.length(); j++){
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c == word.charAt(j)) continue;
                        sb.setCharAt(j, c);
                        String newString = sb.toString();
                        if(words.contains(newString)){
                            buf.add(newString);
                            if(!wordToParentsMapping.containsKey(newString)){
                                wordToParentsMapping.put(newString, new HashSet<>());
                            }
                            wordToParentsMapping.get(newString).add(word);
                        }
                    }
                    sb.setCharAt(j, word.charAt(j));
                }
            }
            for(String word: buf){
                q.add(word);
                words.remove(word);
            }
        }
        return ans;
    }

    private List<List<String>> generateList(HashMap<String, HashSet<String>> mapping, String beginWord, String curWord){
        List<List<String>> ans = new ArrayList<>();
        if(beginWord.equals(curWord)){
            List<String> list = new ArrayList<>();
            list.add(beginWord);
            ans.add(list);
            return ans;
        }
        for(String nextWord: mapping.get(curWord)){
            List<List<String>> tmpLists = generateList(mapping, beginWord, nextWord);
            for(List<String> list: tmpLists){
                list.add(curWord);
            }
            ans.addAll(tmpLists);
        }
        return ans;
    }
}