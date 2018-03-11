class Solution2 {
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        dfs(ret, new ArrayList<>(), s, 0);
        return ret;
    }

    private void dfs(List<List<String>> ret, List<String> tmpL, String s, int start){
        if(start == s.length()){
            ret.add(new ArrayList<>(tmpL));
            return;
        }

        for(int len = 1; start + len <= s.length(); len++){
            String subS = s.substring(start, start + len);
            if(isPalindrome(subS)){
                tmpL.add(subS);
                dfs(ret, tmpL, s, start + len);
                tmpL.remove(tmpL.size() -1);
            }
        }

    }

    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() -1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end --;
        }
        return true;
    }
}