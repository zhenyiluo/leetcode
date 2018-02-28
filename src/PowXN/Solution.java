public class Solution {
    public double myPow(double x, int n) {
        long k = n;
        if(k == 0) return 1;
        if(k < 0){
            x = 1/x;
            k = -k;
        }
        if(k % 2 == 0){
            return myPow(x*x, (int) (k/2));
        }else{
            return x * myPow(x*x, (int) (k/2));
        }
    }
}