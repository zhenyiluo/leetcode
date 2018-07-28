class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(dividend == 0) return 0;
        boolean negative = (dividend < 0) ^ (divisor < 0);
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int ans = 0;
        while(a >= b){
            long multi = 1L;
            while(a >= multi * 2 * b){
                multi *= 2;
            }
            ans += multi;
            a -= multi * b;
        }
        return negative ? -ans : ans;
    }
}