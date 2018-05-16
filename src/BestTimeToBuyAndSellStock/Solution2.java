class Solution2 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int minPrice = Integer.MAX_VALUE;
        int ret = 0;
        for(int price: prices){
            minPrice = Math.min(price, minPrice);
            int profit = price - minPrice;
            ret = Math.max(ret, profit);
        }
        return ret;
    }
}