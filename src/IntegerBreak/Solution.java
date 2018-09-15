class Solution {
    public HashMap<Integer, Integer> cache;

    public int integerBreak(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        if(n == 4) return 4;
        cache = new HashMap<>();
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        return dfs(n);
    }

    private int dfs(int n){
        if(cache.containsKey(n)) return cache.get(n);
        int ans = 3 * dfs(n - 3);
        cache.put(n, ans);
        return ans;
    }
}