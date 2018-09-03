class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        if(board == null || board.length == 0 || board[0].length == 0) return ans;
        if(words == null || words.length == 0) return ans;
        TrieNode root = buildTrie(words);
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dfs(ans, board, i, j, root, visited);
            }
        }
        return ans;
    }

    private void dfs(List<String> ans, char[][] board, int x, int y, TrieNode node, boolean[][] visited){
        char c = board[x][y];
        int idx = c - 'a';
        if(node.children[idx] == null) return;
        TrieNode child = node.children[idx];
        if(child.word != null){
            ans.add(child.word);
            child.word = null;
        }
        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < board.length && ny < board[0].length && !visited[nx][ny]){
                dfs(ans, board, nx, ny, child, visited);
            }
        }
        visited[x][y] = false;
    }

    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String word: words){
            TrieNode cur = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(cur.children[c - 'a'] == null){
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.word = word;
        }
        return root;
    }
}

class TrieNode{
    TrieNode[] children;
    String word;
    public TrieNode(){
        children = new TrieNode[26];
    }
}