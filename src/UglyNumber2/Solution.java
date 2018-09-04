class Solution {
    public int nthUglyNumber(int n) {
        if(n < 0) return 0;
        if(n ==1) return 1;
        int factor2 = 1;
        int factor3 = 1;
        int factor5 = 1;
        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;
        int[] ugly = new int[n];
        for(int i = 0; i < n; i++){
            int min = Math.min(factor2, Math.min(factor3, factor5));
            ugly[i] = min;
            if(factor2 == min) factor2 = 2 * ugly[idx2++];
            if(factor3 == min) factor3 = 3 * ugly[idx3++];
            if(factor5 == min) factor5 = 5 * ugly[idx5++];
        }
        return ugly[n-1];
    }
}