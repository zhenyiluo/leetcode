class Solution2 {
    String[] strs = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if(digits == null || digits.length() == 0) return ret;
        dfs(ret, "", digits);
        return ret;
    }

    private void dfs(List<String> ret, String str, String digits){
        if(digits.length() == 0){
            ret.add(str);
            return;
        }
        int idx = digits.charAt(0) - '2';
        String tmp = strs[idx];
        for(int i = 0; i < tmp.length(); i++){
            dfs(ret, str + tmp.charAt(i), digits.substring(1));
        }
    }
}