import java.util.*;
public class Solution {
    char[][] board;
    HashSet<String> ret;
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        ret = new HashSet<String>();
        if(board == null || board.length == 0 || board[0].length == 0 ||
        words == null || words.length == 0){
            return new LinkedList<>(ret);
        }
        
        Trie trie = new Trie();
        for(String s : words){
            trie.insert(s);
        }
        
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dfs(i, j, trie, "");
            }
        }
        
        return new LinkedList<>(ret);
    }
    
    boolean[][] visited;
    int m;
    int n;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    
    
    private void dfs(int x, int y, Trie trie, String str){
        str = str + board[x][y];
        
        if(!trie.startsWith(str)){
            return;
        }
        
        if(trie.search(str)){
            ret.add(str);
        }
        
        visited[x][y] = true;
        
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny]){
                dfs(nx, ny, trie, str);
            }
        }
        
        visited[x][y] = false;
    }
}

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

class Trie {
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
