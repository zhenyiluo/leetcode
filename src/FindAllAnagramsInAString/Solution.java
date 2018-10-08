class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if(s == null || p == null || s.length() == 0 || p.length() == 0) return ans;
        int count = p.length();
        int[] cnt = new int[256];
        for(int i = 0; i < p.length(); i++){
            cnt[p.charAt(i)] ++;
        }
        int start = 0;
        int end = 0;
        while(end < s.length()){
            if(cnt[s.charAt(end)] >= 1){
                count --;
            }
            cnt[s.charAt(end++)] --;
            if(count == 0){
                ans.add(start);
            }
            if(end - start == p.length()){
                if(cnt[s.charAt(start)] >= 0){
                    count ++;
                }
                cnt[s.charAt(start++)]++;
            }
        }
        return ans;
    }
}