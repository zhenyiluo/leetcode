class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3) return 0;
        int n = A.length;
        int res = 0;
        HashMap<Integer, Integer>[] hms = new HashMap[n];
        for(int i = 0; i < n; i++){
            hms[i] = new HashMap<>();
            for(int j = 0; j < i; j++){
                long diff = (long)A[i] - A[j];
                if(diff >= Integer.MAX_VALUE || diff <= Integer.MIN_VALUE) continue;
                int d = (int) diff;
                int cnti = hms[i].getOrDefault(d, 0);
                int cntj = hms[j].getOrDefault(d, 0);
                res += cntj;
                cnti += cntj + 1;
                hms[i].put(d, cnti);
            }
        }
        return res;
    }
}