class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if(n <= 0) return ans;
        StringBuilder sb = new StringBuilder();
        dfs(ans, n, n, sb);
        return ans;
    }

    private void dfs(List<String> ans, int left, int right, StringBuilder sb){
        if(left == 0 && right == 0){
            ans.add(sb.toString());
            return;
        }
        if(right > left){
            dfs(ans, left, right -1, sb.append(')'));
            sb.deleteCharAt(sb.length() -1);
        }
        if(left > 0){
            dfs(ans, left -1, right, sb.append('('));
            sb.deleteCharAt(sb.length() -1);
        }
    }
}