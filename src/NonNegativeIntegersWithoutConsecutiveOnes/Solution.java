class Solution {
    public int findIntegers(int num) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(num));
        int n = sb.length();
        int[] zero = new int[n];
        int[] one = new int[n];
        zero[0] = 1;
        one[0] = 1;
        for(int i = 1; i < n; i++){
            zero[i] = zero[i-1] + one[i-1];
            one[i] = zero[i-1];
        }
        int res = zero[n-1] + one[n-1];
        for(int i = 1; i < n; i++){
            if(sb.charAt(i) == '0' && sb.charAt(i-1) == '0') res -= one[n-i-1];
            if(sb.charAt(i) == '1' && sb.charAt(i-1) == '1') break;
        }
        return res;
    }
}