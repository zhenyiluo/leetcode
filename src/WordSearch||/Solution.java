class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ret = new ArrayList<>();
        Trie trie = new Trie(words);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, trie.root, i, j, ret);
            }
        }
        return ret;
    }

    private void dfs(char[][] board, TrieNode node, int i, int j, List<String> ret){
        char c = board[i][j];
        if(c == '#' || node.children[c - 'a'] == null) return;
        node = node.children[c - 'a'];
        if(node.word != null){
            ret.add(node.word);
            node.word = null;
        }
        board[i][j] = '#';

        if(i > 0) dfs(board, node, i -1, j, ret);
        if(j > 0) dfs(board, node, i, j -1, ret);
        if(i < board.length -1) dfs(board, node, i+1, j, ret);
        if(j < board[0].length -1) dfs(board, node, i, j+1, ret);
        board[i][j] = c;
    }
}

class Trie{
    TrieNode root;
    public Trie(String[] words){
        root = new TrieNode();
        for(String word: words){
            TrieNode node = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                int idx = c - 'a';
                if(node.children[idx] == null){
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.word = word;
        }
    }
}

class TrieNode{
    TrieNode[] children;
    String word;
    public TrieNode(){
        children = new TrieNode[26];
    }
}