class Solution {
    HashMap<Character, Integer> mapping;
    public Solution(){
        mapping = new HashMap<>();
        mapping.put('I', 1);
        mapping.put('V', 5);
        mapping.put('X', 10);
        mapping.put('L', 50);
        mapping.put('C', 100);
        mapping.put('D', 500);
        mapping.put('M', 1000);
    }
    public int romanToInt(String s) {
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            ans += mapping.get(s.charAt(i));
            if(i > 0 && mapping.get(s.charAt(i)) > mapping.get(s.charAt(i-1))){
                ans -= 2 * mapping.get(s.charAt(i-1));
            }
        }
        return ans;
    }
}