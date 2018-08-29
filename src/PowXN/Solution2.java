class Solution {
    public double myPow(double x, int n) {
        long a = n;
        return myPow(x, a);
    }

    private double myPow(double x, long a){
        if (a == 0) return 1;
        if (a == 1) return x;
        if (a < 0) {
            return 1 / myPow(x, -a);
        }
        double y = myPow(x, a / 2);
        if(a % 2 == 0){
            return y * y;
        }else{
            return x * y * y;
        }
    }
}