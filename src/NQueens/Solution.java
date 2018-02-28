class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> ret = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        dfs(board, ret, 0);
        return ret;
    }

    private void dfs(char[][] board, List<List<String>> ret, int row){
        int n = board.length;
        if(row == n){
            ret.add(construct(board));
        }

        for(int j = 0; j < n; j++){
            if(isValid(board, row, j)){
                board[row][j] = 'Q';
                dfs(board, ret, row+1);
                board[row][j] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int x, int y){
        for(int i = 0; i < x; i++){
            for(int j =0; j < board[0].length; j++){
                if(board[i][j] == 'Q'){
                    if(j == y || Math.abs(i - x) == Math.abs(j - y)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private List<String> construct(char[][] board){
        List<String> ret = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            ret.add(new String(board[i]));
        }
        return ret;
    }
}