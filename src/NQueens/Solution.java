public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<>();
        int[] a = new int[n];
        dfs(0, n, a, ret);
        return ret;
    }

    private void dfs(int row, int n, int[] a, List<List<String>> ret){
        if(row == n){
            addToResult(n, a, ret);
        }
        for(int i = 0; i < n; i++){
            if(check(row, i, a)){
                a[row] = i;
                dfs(row + 1, n, a, ret);
            }
        }
    }

    private boolean check(int row, int num, int[] a){
        for(int i= 0; i< row; i++){
            if(a[i] == num || Math.abs(row - i) == Math.abs(num - a[i])){
                return false;
            }
        }
        return true;
    }

    private void addToResult(int n, int[] a, List<List<String>> ret){
        List<String> tmp = new ArrayList<>();
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                if(a[i] == j){
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
            }
            tmp.add(sb.toString());
        }
        ret.add(tmp);
    }
}