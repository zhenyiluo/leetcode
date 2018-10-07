class Solution {
    public int longestSubstring(String s, int k) {
        int ans = 0;
        for(int h = 1; h <= 26; h ++){
            HashMap<Character, Integer> hm = new HashMap<>();
            int i = 0;
            int cnt = 0;
            for(int j = 0; j < s.length(); j++){
                char r = s.charAt(j);
                hm.put(r, hm.getOrDefault(r, 0) + 1);
                if(hm.get(r) == k){
                    cnt ++;
                }
                while(hm.size() > h){
                    char l = s.charAt(i++);
                    if(hm.get(l) == k){
                        cnt --;
                    }
                    hm.put(l, hm.get(l) - 1);
                    if(hm.get(l) == 0){
                        hm.remove(l);
                    }
                }
                if(cnt == h){
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}