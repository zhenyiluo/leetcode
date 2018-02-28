class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ret = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int start = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(hm.containsKey(c)){
                start = Math.max(start, hm.get(c) + 1);
            }
            hm.put(c, i);
            ret = Math.max(ret, i - start + 1);
        }
        return ret;
    }
}