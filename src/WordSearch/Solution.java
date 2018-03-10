class Solution {
    final static int[] dx = {-1, 1, 0, 0};
    final static int[] dy = {0, 0, -1, 1};
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0) return true;
        if(board == null || board.length == 0 || board[0].length == 0) return false;
        int m = board.length;
        int n = board[0].length;
        if(m * n < word.length()){
            return false;
        }
        boolean[][] visited;
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    visited = new boolean[m][n];
                    visited[i][j] = true;
                    if(dfs(board, i, j, word.substring(1), visited)){
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int x, int y, String word, boolean[][] visited){
        if(word.length() == 0){
            return true;
        }
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < board.length && ny < board[0].length && !visited[nx][ny] && board[nx][ny] == word.charAt(0)){
                visited[nx][ny] = true;
                if(dfs(board, nx, ny, word.substring(1), visited)){
                    return true;
                }
                visited[nx][ny] = false;
            }
        }
        return false;
    }
}