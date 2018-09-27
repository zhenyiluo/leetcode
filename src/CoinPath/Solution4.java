class Solution {
    public List<Integer> cheapestJump(int[] A, int B) {
        List<Integer> ans = new ArrayList<>();
        int n = A.length;
        int[] dp = new int[n];
        int[] forward = new int[n];
        for(int i = 0; i < n; i++){
            forward[i] = -1;
            dp[i] = Integer.MAX_VALUE;
        }
        dp[n-1] = A[n-1];
        for(int i = n -2; i >=0; i--){
            if(A[i] == -1) continue;
            for(int j = i +1; j <= Math.min(n-1, i + B); j ++){
                if(A[j] == -1 || dp[j] == Integer.MAX_VALUE) continue;
                if(dp[j] + A[i] < dp[i]){
                    dp[i] = dp[j] + A[i];
                    forward[i] = j;
                }
            }
        }
        if(dp[0] == Integer.MAX_VALUE) return ans;
        int k = 0;
        while(k != -1){
            ans.add(k + 1);
            k = forward[k];
        }
        return ans;
    }
}