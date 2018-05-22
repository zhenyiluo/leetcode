class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean negative = (dividend < 0) ^ (divisor < 0) ? true : false;
        long d1 = Math.abs((long) dividend);
        long d2 = Math.abs((long) divisor);
        int ans = 0;
        while(d1 >= d2){
            long multiple = 1;
            while(d1 >= multiple * 2 * d2){
                multiple *= 2;
            }
            ans += multiple;
            d1 -= multiple * d2;
        }
        return negative ? -ans : ans;
    }
}