class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <=1) return 0;
        int buyOne = Integer.MAX_VALUE;
        int sellOne = 0;
        int buyTwo = Integer.MAX_VALUE;
        int sellTwo = 0;
        for(int price: prices){
            buyOne = Math.min(buyOne, price);
            sellOne = Math.max(sellOne, price - buyOne);
            buyTwo = Math.min(buyTwo, price - sellOne);
            sellTwo = Math.max(sellTwo, price - buyTwo);
        }
        return sellTwo;
    }
}