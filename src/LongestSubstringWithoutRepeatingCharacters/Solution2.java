class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int left = -1;
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(hm.containsKey(c)){
                left = Math.max(left, hm.get(c));
            }
            ans = Math.max(ans, i - left);
            hm.put(c, i);
        }
        return ans;
    }
}