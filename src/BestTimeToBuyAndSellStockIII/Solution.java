class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int n = prices.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            min = Math.min(min, prices[i]);
            left[i] = Math.max(0, prices[i] - min);
            if(i > 0){
                left[i] = Math.max(left[i-1], left[i]);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = n-1; i >= 0; i--){
            max = Math.max(max, prices[i]);
            right[i] = Math.max(0, max - prices[i]);
            if(i < n - 1){
                right[i] = Math.max(right[i+1], right[i]);
            }
        }
        int ret = 0;
        for(int i = 0; i < n; i++){
            ret = Math.max(ret, left[i] + right[i]);
        }
        return ret;
    }
}