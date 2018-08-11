class Solution {
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        if(board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0){
            return ans;
        }
        TrieNode root = buildTrie(words);
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                TrieNode cur = root;
                dfs(board, cur, i, j, visited, ans);
            }
        }
        return ans;
    }

    private void dfs(char[][] board, TrieNode node, int x, int y, boolean[][] visited, List<String> ans){
        char c = board[x][y];
        if(node.children[c - 'a'] == null) return;
        node = node.children[c - 'a'];
        if(node.word != null){
            ans.add(node.word);
            node.word = null;
        }
        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < board.length && ny < board[0].length && !visited[nx][ny]){
                dfs(board, node, nx, ny, visited, ans);
            }
        }
        visited[x][y] = false;
    }

    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String word: words){
            TrieNode cur = root;
            if(word == null || word.length() == 0) continue;
            for(int i = 0; i < word.length(); i++){
                int index = word.charAt(i) - 'a';
                if(cur.children[index] == null){
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }
            cur.word = word;
        }
        return root;
    }

}

class TrieNode{
    String word;
    TrieNode[] children;
    public TrieNode(){
        children = new TrieNode[26];
    }
}