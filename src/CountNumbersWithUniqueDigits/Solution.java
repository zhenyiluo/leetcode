class Solution {
    private HashMap<Integer, Integer> cache = new HashMap<>();
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        if(n == 1) return 10;
        if(n == 2) return 91;
        cache.put(1, 10);
        cache.put(2, 81);
        int ans = 0;
        for(int i = 1; i <= n && i < 11; i++){
            ans += helper(i);
        }
        return ans;
    }

    private int helper(int n){
        if(cache.containsKey(n)){
            return cache.get(n);
        }
        int ans = (11 - n) * helper(n-1);
        cache.put(n, ans);
        return ans;
    }
}