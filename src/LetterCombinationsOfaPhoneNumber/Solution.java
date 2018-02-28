class Solution {
    public List<String> letterCombinations(String digits) {
        String[] panel = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ret = new LinkedList<>();
        if(digits == null || digits.length() == 0) return ret;
        dfs(digits, "", ret, panel);
        return ret;
    }

    private void dfs(String digits, String cur, List<String> ret, String[] panel){
        if(digits.length() == 0){
            ret.add(cur);
            return;
        }
        int index = digits.charAt(0) - '2';
        for(int i = 0; i < panel[index].length(); i++){
            dfs(digits.substring(1), cur + String.valueOf(panel[index].charAt(i)), ret, panel);
        }
        return;
    }
}