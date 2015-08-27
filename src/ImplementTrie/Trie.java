class TrieNode {
    char val;
    TrieNode[] children;
    boolean endFlag;
    // Initialize your data structure here.
    public TrieNode() {
        children = new TrieNode[26];
        endFlag = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(word == null || word.length() == 0){
            return;
        }
        int len = word.length();
        TrieNode cur = root;
        for(int i = 0; i < len; i++){
            char c = word.charAt(i);
            int index = c - 'a';
            if(cur.children[index] == null){
               TrieNode node = new TrieNode();
               node.val = c; 
               cur.children[index] = node;
            }
            cur = cur.children[index];
        }
        cur.endFlag = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if(word == null || word.length() == 0){
            return false;
        }
        TrieNode node = searchNode(word);
        if(node == null){
            return false;
        }else{
           return node.endFlag; 
        }
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0){
            return false;
        }
        TrieNode node = searchNode(prefix);
        
        if(node != null){
            return true;
        }else{
            return false;
        }
    }
    
    private TrieNode searchNode(String s){
        int len = s.length();
        TrieNode cur = root;
        for(int i = 0; i < len; i++){
           char c = s.charAt(i);
           int index = c - 'a';
           if(cur.children[index] == null){
               return null;
           }
           cur = cur.children[index];
        }
        return cur;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");