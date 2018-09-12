class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<>();
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        TrieNode root = new TrieNode();
        for(String word: words){
            if(canForm(word, 0, root, 0)){
                ans.add(word);
            }
            addWord(root, word);
        }
        return ans;
    }

    private boolean canForm(String word, int start, TrieNode root, int count){
        TrieNode cur = root;
        int len = word.length();
        for(int i = start; i < len; i++){
            int idx = word.charAt(i) - 'a';
            if(cur.children[idx] == null){
                return false;
            }
            if(cur.children[idx].isEnd){
                if(i == len -1) {
                    return count >= 1;
                }
                if(canForm(word, i+1, root, count+1)){
                    return true;
                }
            }
            cur = cur.children[idx];
        }
        return false;
    }

    private void addWord(TrieNode root, String word){
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(cur.children[idx] == null){
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx];
        }
        cur.isEnd = true;
    }
}

class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    public TrieNode(){
        children = new TrieNode[26];
    }
}