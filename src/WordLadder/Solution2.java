class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null || wordList.size() == 0) return 0;
        HashSet<String> words = new HashSet<>();
        for(String word: wordList){
            words.add(word);
        }
        if(!words.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int step = 0;
        while(!q.isEmpty()){
            step++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                String word = q.poll();
                if(word.equals(endWord)) return step;
                StringBuilder tmp = new StringBuilder(word);
                for(int j = 0; j < word.length(); j++){
                    for(char c = 'a' ; c <= 'z'; c++){
                        if(c == word.charAt(j)) continue;
                        tmp.setCharAt(j, c);
                        String newStr = tmp.toString();
                        if(words.contains(newStr)){
                            q.add(newStr);
                            words.remove(newStr);
                        }
                    }
                    tmp.setCharAt(j, word.charAt(j));
                }
            }
        }
        return 0;
    }
}