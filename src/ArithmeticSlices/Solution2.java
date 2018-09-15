class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3) return 0;
        int n = A.length;
        int sum = 0;
        int cur = 0;
        for(int i = 0; i < n-2; i++){
            if(A[i+1] - A[i] == A[i+2] - A[i+1]){
                cur ++;
                sum += cur;
            }else{
                cur = 0;
            }
        }
        return sum;
    }
}