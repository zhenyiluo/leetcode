class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int i = 0;
        int ans = 0;
        for(int j = 0; j < s.length(); j++){
            char r = s.charAt(j);
            hm.put(r, hm.getOrDefault(r, 0) + 1);
            while(hm.size() > k){
                char l = s.charAt(i++);
                hm.put(l, hm.get(l) - 1);
                if(hm.get(l) == 0){
                    hm.remove(l);
                }
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}