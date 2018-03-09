class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0) return 0;
        int ret = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int i = 0;
        for(int j = 0; j < s.length(); j++){
            char c = s.charAt(j);
            hm.put(c, hm.getOrDefault(c, 0) + 1);
            while(hm.size() > 2){
                char left = s.charAt(i);
                hm.put(left, hm.get(left) -1);
                if(hm.get(left) == 0){
                    hm.remove(left);
                }
                i++;
            }
            ret = Math.max(ret, j - i + 1);
        }
        return ret;
    }

}