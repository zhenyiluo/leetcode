public class WordDictionary {
    static class TrieNode{
        TrieNode[] children; 
        boolean wordEndHere;
        public TrieNode(){
            children = new TrieNode[26];
            wordEndHere = false;
        }
    }
    
    TrieNode root;
    
    public WordDictionary(){
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        if(word == null || word.length() == 0 || search(word)){
            return;
        }
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int index = c - 'a';
            if(cur.children[index] == null){
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.wordEndHere = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(word == null || word.length() == 0){
            return false;
        }
        TrieNode cur = root;
        return search(word, cur);
    }
    private boolean search(String word, TrieNode node){
        if(word.length() == 0){
            return node.wordEndHere;
        }
        char c = word.charAt(0);
        if(c == '.'){
            for(int i = 0; i < 26; i++){
                if(node.children[i] != null){
                    if(search(word.substring(1), node.children[i])){
                        return true;
                    }
                }
            }
            return false;
        }else{
            if(node.children[c-'a'] == null){
                return false;
            }
            return search(word.substring(1), node.children[c- 'a']);
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");