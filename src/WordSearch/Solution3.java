class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0) return false;
        if(word.length() == 0) return true;
        int m = board.length;
        int n = board[0].length;
        if(m * n < word.length()) return false;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, word.substring(1), i, j, visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int x, int y, boolean[][] visited){
        if(word.length() == 0) return true;
        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < board.length && ny < board[0].length && word.charAt(0) == board[nx][ny]
                    && !visited[nx][ny]){
                if(dfs(board, word.substring(1), nx, ny, visited)){
                    return true;
                }
            }
        }
        visited[x][y] = false;
        return false;
    }
}