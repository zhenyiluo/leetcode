public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int ret = 0; 
        int shift = 0;
        while(m > 0){
            if(m == n && (m & 1) != 0){
                ret |= 1 << shift;
            }
            shift ++;
            m >>= 1;
            n >>= 1;
        }
        return ret;
    }
}