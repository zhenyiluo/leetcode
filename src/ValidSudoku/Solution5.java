class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9) return false;
        for(int i = 0; i < 9; i ++){
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.' && !row.add(board[i][j])) return false;
                if(board[j][i] != '.' && !col.add(board[j][i])) return false;
                int r = i / 3 * 3 + j / 3;
                int c = i % 3 * 3 + j % 3;
                if(board[r][c] != '.' && !cube.add(board[r][c])) return false;
            }
        }
        return true;
    }
}