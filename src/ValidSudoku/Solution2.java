class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> cubes = new HashSet<>();
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.' && !rows.add(board[i][j])) return false;
                if(board[j][i] != '.' && !cols.add(board[j][i])) return false;
                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                if(board[rowIndex + j / 3][colIndex + j % 3] != '.' && !cubes.add(board[rowIndex+ j /3][colIndex + j % 3])){
                    return false;
                }
            }
        }
        return true;
    }
}