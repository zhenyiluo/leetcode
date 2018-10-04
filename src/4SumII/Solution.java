class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int sum = C[i] + D[j];
                hm.put(sum, hm.getOrDefault(sum, 0) + 1);
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                ans += hm.getOrDefault(-1 * (A[i] + B[j]), 0);
            }
        }
        return ans;
    }
}