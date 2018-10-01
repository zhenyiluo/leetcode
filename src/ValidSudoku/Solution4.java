class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> cubes = new HashSet<>();
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.' && !rows.add(board[i][j])) return false;
                if(board[j][i] != '.' && !cols.add(board[j][i])) return false;
                int r = i / 3 * 3 + j / 3;
                int c = i % 3 * 3 + j % 3;
                if(board[r][c] != '.' && !cubes.add(board[r][c])) return false;
            }
        }
        return true;
    }
}