class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length <= 1 || k <= 0) return 0;
        if(prices.length <= k * 2){
            int profit = 0;
            for(int i = 1; i < prices.length; i++){
                profit += Math.max(0, prices[i] - prices[i-1]);
            }
            return profit;
        }

        int[] buyStock = new int[k];
        int[] sellStock = new int[k];
        for(int i = 0; i < k ; i++){
            buyStock[i] = Integer.MAX_VALUE;
        }

        for(int price: prices){
            for(int i = 0; i < k; i++){
                if(i == 0){
                    buyStock[i] = Math.min(buyStock[i], price);
                }else{
                    buyStock[i] = Math.min(buyStock[i], price - sellStock[i-1]);
                }
                sellStock[i] = Math.max(sellStock[i], price - buyStock[i]);
            }
        }

        return sellStock[k-1];
    }
}