class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9){
            return false;
        }
        HashSet<Character> hs;
        for(int i = 0; i < 9; i++){
            hs = new HashSet<>();
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                if(!hs.contains(board[i][j])){
                    hs.add(board[i][j]);
                }else{
                    return false;
                }
            }
        }

        for(int j = 0; j < 9; j++){
            hs = new HashSet<>();
            for(int i = 0; i < 9; i++){
                if(board[i][j] == '.') continue;
                if(!hs.contains(board[i][j])){
                    hs.add(board[i][j]);
                }else{
                    return false;
                }
            }
        }

        for(int i = 0; i< 3; i++){
            for(int j = 0; j < 3; j++){
                hs = new HashSet<>();
                for(int k = 0; k < 3; k++){
                    for(int l = 0; l < 3; l ++){
                        int x = i * 3 + k;
                        int y = j * 3 + l;
                        if(board[x][y] == '.') continue;
                        if(!hs.contains(board[x][y])){
                            hs.add(board[x][y]);
                        }else{
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}