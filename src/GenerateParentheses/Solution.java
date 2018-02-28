class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new LinkedList<>();
        build(n, n, ret, "");
        return ret;
    }

    private void build(int left, int right, List<String> ret, String s){
        if(left == 0 && right == 0){
            ret.add(s);
            return;
        }
        if(left > 0){
            build(left -1, right, ret, s + "(");
        }
        if(left < right){
            build(left, right -1, ret, s + ")");
        }
    }
}