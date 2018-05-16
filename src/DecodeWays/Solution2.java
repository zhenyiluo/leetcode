class Solution2 {
    HashMap<String, Integer> hm = new HashMap<>();
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        return dfs(s);
    }

    private int dfs(String s){
        if(hm.containsKey(s)) return hm.get(s);
        if(s.length() == 0) return 1;
        if(s.charAt(0) == '0') return 0;
        if(s.length() == 1) return 1;
        int ans = 0;
        ans += dfs(s.substring(1));
        int val = Integer.valueOf(s.substring(0, 2));
        if(val <= 26){
            ans += dfs(s.substring(2));
        }
        hm.put(s, ans);
        return ans;
    }
}