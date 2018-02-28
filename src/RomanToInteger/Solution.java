class Solution {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);
        int ret = 0;
        for(int i = 0; i < s.length(); i++){
            ret += hm.get(s.charAt(i));
            if(i > 0 && hm.get(s.charAt(i)) > hm.get(s.charAt(i-1))){
                ret -= 2 * hm.get(s.charAt(i-1));
            }
        }
        return ret;
    }
}