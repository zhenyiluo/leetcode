class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1 == null || s2 == null) return false;
        if(s1.length() != s2.length()) return false;
        if(!isValid(s1, s2)){
            return false;
        }
        if(s1.length() <= 1){
            return true;
        }

        for(int i = 1; i < s1.length(); i++){
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);

            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);

            String s23 = s2.substring(0, s2.length() - i);
            String s24 = s2.substring(s2.length() -i);
            if(isScramble(s11, s21) && isScramble(s12, s22)) return true;
            if(isScramble(s11, s24) && isScramble(s12, s23)) return true;
        }
        return false;
    }

    private boolean isValid(String s1, String s2){
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return String.valueOf(c1).equals(String.valueOf(c2));
    }
}