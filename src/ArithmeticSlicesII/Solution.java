class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        HashMap<Integer, Integer>[] hm = new HashMap[n];
        int ans = 0;
        for(int i = 0; i < n; i++){
            hm[i] = new HashMap<>();
            for(int j = 0; j < i; j++){
                long diff = (long) A[j] - A[i];
                if(diff >= Integer.MAX_VALUE || diff <= Integer.MIN_VALUE) continue;
                int d = (int) diff;
                int c1 = hm[i].getOrDefault(d, 0);
                int c2 = hm[j].getOrDefault(d, 0);
                ans += c2;
                hm[i].put(d, c1 + c2 + 1);
            }
        }
        return ans;
    }
}