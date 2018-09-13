class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(stones[i], i);
        }
        dp[0][0] = true;
        for(int i = 0; i < n-1; i ++){
            for(int j = 0; j <= i; j++){
                if(dp[i][j]){
                    for(int k = Math.max(1, j-1); k <= j+1; k++){
                        if(map.containsKey(stones[i] + k)){
                            int idx = map.get(stones[i] + k);
                            if(idx == n-1) return true;
                            dp[idx][k] = true;
                        }
                    }
                }
            }
        }
        return false;
    }
}