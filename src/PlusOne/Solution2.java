class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return new int[]{};
        int n = digits.length;
        int[] ans = new int[n];
        int carryOver = 1;
        for(int i = n-1; i>= 0; i--){
            int sum = digits[i] + carryOver;
            if(sum == 10){
                carryOver = 1;
                ans[i] = 0;
            }else{
                carryOver = 0;
                ans[i] = sum;
            }
        }
        if(carryOver != 0){
            int[] ret = new int[n+1];
            ret[0] = 1;
            for(int i = 0; i < n; i++){
                ret[i+1] = ans[i];
            }
            return ret;
        }else{
            return ans;
        }
    }
}