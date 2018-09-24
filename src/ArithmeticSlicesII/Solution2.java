class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3) return 0;
        int n = A.length;
        HashMap<Integer, Integer>[] maps = new HashMap[n];
        int ans = 0;
        for(int i = 0; i < n; i++){
            maps[i] = new HashMap<>();
            for(int j = 0; j < i; j++){
                long diff = (long) A[i] - A[j];
                if(diff >= Integer.MAX_VALUE || diff <= Integer.MIN_VALUE) continue;
                int d = (int) diff;
                int c1 = maps[i].getOrDefault(d, 0);
                int c2 = maps[j].getOrDefault(d, 0);
                ans += c2;
                maps[i].put(d, c1 + c2 + 1);
            }
        }
        return ans;
    }
}