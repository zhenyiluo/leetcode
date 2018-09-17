class Solution {
    HashMap<List<Integer>, Integer> cache = new HashMap<>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        List<List<Integer>> goodSpecial = new ArrayList<>();
        for(List<Integer> offer: special){
            int cost1 = 0;
            int cost2 = offer.get(offer.size()-1);
            for(int i = 0; i < price.size(); i++){
                cost1 += price.get(i) * offer.get(i);
            }
            if(cost1 > cost2) goodSpecial.add(offer);
        }
        special = goodSpecial;
        return dfs(price, special, needs);
    }

    public int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if(cache.containsKey(needs)) return cache.get(needs);
        int sum = 0;
        for(int need: needs){
            sum += need;
        }
        if(sum == 0) {
            cache.put(needs, 0);
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        boolean foundOffer = false;
        for(List<Integer> offer: special){
            boolean accept = true;
            for(int i = 0; i < offer.size() -1 && accept; i++){
                if(offer.get(i) > needs.get(i)){
                    accept = false;
                }
            }
            if(accept){
                foundOffer = true;
                for(int i = 0; i < offer.size() -1; i++){
                    needs.set(i, needs.get(i) - offer.get(i));
                }
                ans = Math.min(ans, offer.get(offer.size() -1) + dfs(price, special, needs));
                for(int i = 0; i < offer.size() - 1; i++){
                    needs.set(i, needs.get(i) + offer.get(i));
                }
            }
        }
        if(!foundOffer){
            ans = 0;
            for(int i = 0; i < price.size(); i++){
                ans += price.get(i) * needs.get(i);
            }
        }
        cache.put(needs, ans);
        return ans;
    }

}