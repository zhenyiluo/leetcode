class Solution2 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ret = new ArrayList<>();
        if(s == null || s.length() == 0) {
            ret.add(s);
            return ret;
        }
        dfs(ret, s, new char[]{'(', ')'}, 0, 0);
        return ret;
    }

    private void dfs(List<String> ret, String s, char[] par, int last_i, int last_j){
        for(int i = last_i, stack = 0; i < s.length(); i++){
            if(s.charAt(i) == par[0]) stack ++;
            if(s.charAt(i) == par[1]) stack --;
            if(stack >= 0) continue;
            for(int j = last_j; j <= i; j++){
                if(s.charAt(j) == par[1] && (j == last_j || s.charAt(j-1) != par[1])){
                    dfs(ret, s.substring(0, j) + s.substring(j+1), par, i, j);
                }
            }
            return;
        }
        String reverse = new StringBuilder(s).reverse().toString();
        if(par[0] == '('){
            dfs(ret, reverse, new char[]{')', '('}, 0, 0);
        }else{
            ret.add(reverse);
        }
    }
}