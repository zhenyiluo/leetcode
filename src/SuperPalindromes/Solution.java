class Solution {
    public int superpalindromesInRange(String L, String R) {
        long l = Long.valueOf(L);
        long r = Long.valueOf(R);
        int ret = 0;
        for(long i = (long) Math.sqrt(l); i * i <= r;){
            long p = nextP(i);
            if(p * p <= r && isP(p * p)){
                ret ++;
            }
            i = p + 1;
        }
        return ret;
    }

    private long nextP(long p){
        List<Long> cands = new ArrayList<>();
        String s = "" + p;
        int len = s.length();
        String half = s.substring(0, (len+1)/2);
        String nextHalf = "" + (Long.valueOf(half) + 1);
        String halfReverse = new StringBuilder(half.substring(0, len/2)).reverse().toString();
        String nextHalfReverse = new StringBuilder(nextHalf.substring(0, len/2)).reverse().toString();
        cands.add(Long.valueOf(half + halfReverse));
        cands.add(Long.valueOf(nextHalf + nextHalfReverse));
        long min = Long.MAX_VALUE;
        for(Long cand: cands){
            if(cand >= p){
                min = Math.min(min, cand);
            }
        }
        return min;
    }

    private boolean isP(long p){
        String s = "" + p;
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(s.charAt(left++) != s.charAt(right--)){
                return false;
            }
        }
        return true;
    }
}