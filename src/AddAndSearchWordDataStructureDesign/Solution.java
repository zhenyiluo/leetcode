class WordDictionary {
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(word == null || word.length() == 0) return;
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c= word.charAt(i);
            int idx = c - 'a';
            if(node.children[idx] == null){
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.endOfWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word == null || word.length() == 0) return false;
        TrieNode node = root;
        return search(word, node);
    }

    private boolean search(String word, TrieNode node){
        if(node == null) return false;
        if(word.length() == 0) return node.endOfWord;
        char c = word.charAt(0);
        if(c == '.'){
            for(TrieNode child: node.children){
                if(child != null){
                    if(search(word.substring(1), child)){
                        return true;
                    }
                }
            }
            return false;
        }else{
            int idx = c - 'a';
            return search(word.substring(1), node.children[idx]);
        }
    }
}

class TrieNode{
    TrieNode[] children;
    boolean endOfWord = false;
    public TrieNode(){
        children = new TrieNode[26];
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */