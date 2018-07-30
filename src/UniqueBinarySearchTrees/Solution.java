class Solution {
    private HashMap<Integer, Integer> cache = new HashMap<>();
    public int numTrees(int n) {
        if(n <= 1) return 1;
        if(cache.containsKey(n)) return cache.get(n);
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += numTrees(i-1) * numTrees(n - i);
        }
        cache.put(n, sum);
        return sum;
    }
}