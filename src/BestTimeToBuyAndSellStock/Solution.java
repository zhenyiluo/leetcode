class Solution {
    public int maxProfit(int[] prices) {
        int ret = 0;
        int small = Integer.MAX_VALUE;
        for(int price : prices){
            small = Math.min(small, price);
            ret = Math.max(ret, price - small);
        }
        return ret;
    }
}