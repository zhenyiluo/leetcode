class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;
        boolean negative = (dividend < 0) ^ (divisor < 0) ? true : false;
        long div = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        int ret = 0;
        while(div >= dvs){
            long tmp = dvs;
            long mul = 1;
            while(div >= (tmp<< 1)){
                tmp <<= 1;
                mul <<=1;
            }
            div -= tmp;
            ret += mul;
        }
        return negative ? -ret : ret;
    }
}