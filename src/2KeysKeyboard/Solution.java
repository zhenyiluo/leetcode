class Solution {
    public HashMap<Integer, Integer> cache = new HashMap<>();
    public int minSteps(int n) {
        if(cache.containsKey(n)) return cache.get(n);
        if(n == 1) {
            cache.put(n, 0);
            return 0;
        }
        if(n == 2) {
            cache.put(n, 2);
            return 2;
        }
        if(n == 3){
            cache.put(n, 3);
            return 3;
        }
        int ld = helper(n);
        if(ld == 1){
            cache.put(n, n);
            return n;
        }else{
            int num = n / ld;
            int ret = num + minSteps(ld);
            cache.put(n, ret);
            return ret;
        }
    }

    private int helper(int n){
        int ans = 1;
        for(int i = 2; i *2 <= n; i++){
            if(n % i == 0){
                ans = i;
            }
        }
        return ans;
    }
}