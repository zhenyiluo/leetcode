class Solution {
    HashMap<String, Integer> hm = new HashMap<>();
    public int numDecodings(String s) {
        if(s == null) return 0;
        if(s.length() == 0) return 1;
        if(s.charAt(0) == '0') return 0;
        if(hm.containsKey(s)) return hm.get(s);
        int ans = 0;
        ans += numDecodings(s.substring(1));
        if(s.length() >= 2){
            int val = Integer.valueOf(s.substring(0, 2));
            if(val > 0 && val <= 26){
                ans += numDecodings(s.substring(2));
            }
        }
        hm.put(s, ans);
        return ans;
    }
}