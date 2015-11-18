public class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }

        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int countLive = count(board, i, j);
                if((board[i][j] & 1)== 1){
                    if(countLive >= 2 &&  countLive <= 3){
                        board[i][j] = 3;
                    }
                }else{
                    if(countLive == 3){
                        board[i][j] = 2;
                    }
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] >>= 1;
            }
        }
    }

    private int count(int[][] board, int x, int y){
        int ret = 0;
        int m = board.length;
        int n = board[0].length;
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                if(i == 0 && j == 0){
                    continue;
                }
                int nx = x + i;
                int ny = y + j;
                if(nx >= 0 && ny >= 0 && nx < m && ny < n){
                    if((board[nx][ny] & 1) == 1){
                        ret ++;
                    }
                }
            }
        }
        return ret;
    }
}