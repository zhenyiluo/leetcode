class Solution {
    private static int[] dx = new int[]{-1, 1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0) return false;
        if(word == null || word.length() == 0) return true;
        int m = board.length;
        int n = board[0].length;
        if(m * n < word.length()) return false;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, visited, i, j, word.substring(1))){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int x, int y, String word){
        if(word.length() == 0) return true;
        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && !visited[nx][ny] && board[nx][ny] == word.charAt(0)){
                if(dfs(board, visited, nx, ny, word.substring(1))){
                    return true;
                }
            }
        }
        visited[x][y] = false;
        return false;
    }
}