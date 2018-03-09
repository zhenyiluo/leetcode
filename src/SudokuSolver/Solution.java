class Solution {
    HashSet<Character>[] rowHs = new HashSet[9];
    HashSet<Character>[] colHs = new HashSet[9];
    HashSet<Character>[][] subHs = new HashSet[3][3];
    public void solveSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9){
            return;
        }
        for(int i = 0; i < 9; i++){
            rowHs[i] = new HashSet<>();
            colHs[i] = new HashSet<>();
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                subHs[i][j] = new HashSet<>();
            }
        }
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    rowHs[i].add(board[i][j]);
                    colHs[j].add(board[i][j]);
                    subHs[i/3][j/3].add(board[i][j]);
                }
            }
        }
        dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board, int row, int col){
        if(row == 9) return true;
        if(col == 9) return dfs(board, row+1, 0);
        if(board[row][col] != '.'){
            if(dfs(board, row, col + 1)){
                return true;
            }else{
                return false;
            }
        }
        for(char c = '1'; c <= '9'; c++){
            if(check(board, row, col, c)){
                rowHs[row].add(c);
                colHs[col].add(c);
                subHs[row/3][col/3].add(c);
                board[row][col] = c;
                if(dfs(board, row, col + 1)){
                    return true;
                }
                rowHs[row].remove(c);
                colHs[col].remove(c);
                subHs[row/3][col/3].remove(c);
            }
        }
        board[row][col] = '.';
        return false;
    }

    private boolean check(char[][] board, int row, int col, char c){
        if(rowHs[row].contains(c)) return false;
        if(colHs[col].contains(c)) return false;
        if(subHs[row/3][col/3].contains(c)) return false;
        return true;
    }
}