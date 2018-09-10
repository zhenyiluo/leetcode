class Solution {
    public List<Integer> cheapestJump(int[] A, int B) {
        List<Integer> ans = new ArrayList<>();
        int n = A.length;
        int[] dp = new int[n];
        int[] forward = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = Integer.MAX_VALUE;
            forward[i] = -1;
        }
        dp[n-1] = A[n-1];
        for(int i = n-2; i >= 0; i--){
            if(A[i] == -1) continue;
            for(int j = i + 1; j <= Math.min(i+B, A.length -1); j++){
                if(A[j] == -1 || dp[j] == Integer.MAX_VALUE) continue;
                if(dp[i] > A[i] + dp[j]){
                    dp[i] = A[i] + dp[j];
                    forward[i] = j;
                }
            }
        }

        if(dp[0] == Integer.MAX_VALUE){
            return ans;
        }

        int k = 0;
        while(k != -1){
            ans.add(k+1);
            k = forward[k];
        }
        return ans;
    }
}