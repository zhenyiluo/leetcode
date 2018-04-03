class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        int n = flowers.length;
        int[] bloomDays = new int[n];
        for(int i = 0; i < n; i++){
            bloomDays[flowers[i] - 1] = i + 1;
        }
        int ret = Integer.MAX_VALUE;
        int left = 0;
        int right = k+1;
        for(int i = 1; right < n; i++){
            if(bloomDays[i] > bloomDays[left] && bloomDays[i] > bloomDays[right]){
                continue;
            }
            if(i == right){
                ret = Math.min(ret, Math.max(bloomDays[left], bloomDays[right]));
            }
            left = i;
            right = k + i + 1;
        }
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }
}