class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if(A == null || A.length == 0) return 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = A.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int sum = C[i] + D[j];
                hm.put(sum, hm.getOrDefault(sum, 0) + 1);
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int sum = -A[i] - B[j];
                ans += hm.getOrDefault(sum, 0);
            }
        }
        return ans;
    }
}