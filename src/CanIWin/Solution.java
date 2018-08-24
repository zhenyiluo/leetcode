class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger * (maxChoosableInteger +1) /2 < desiredTotal) return false;
        return canIWin(0, new HashMap<Integer, Boolean>(), desiredTotal, maxChoosableInteger);
    }

    private boolean canIWin(int state, HashMap<Integer, Boolean> hm, int total, int n){
        if(hm.containsKey(state)) return hm.get(state);
        for(int i = 0; i < n; i++){
            if((state & (1 << i)) != 0) continue;
            if(i +1 >= total || !canIWin(state | (1 << i), hm, total - i - 1, n)){
                hm.put(state, true);
                return true;
            }
        }
        hm.put(state, false);
        return false;
    }
}