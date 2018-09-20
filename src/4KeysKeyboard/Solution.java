class Solution {
    HashMap<Integer, Integer> cache = new HashMap<>();
    public int maxA(int N) {
        if(cache.containsKey(N)) return cache.get(N);
        if(N <= 6) {
            cache.put(N, N);
            return N;
        }
        int ans = 0;
        for(int i = 1; i <= N - 3; i++){
            ans = Math.max(ans, maxA(i) * (N -i - 1));
        }
        cache.put(N, ans);
        return ans;
    }
}