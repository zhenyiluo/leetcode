class Solution {
    public String nearestPalindromic(String n) {
        String s = n;
        Long l = Long.valueOf(s);
        int len = s.length();
        List<Long> cands = new ArrayList<>();
        String half = s.substring(0, (len+1)/2);
        String prevHalf = "" + (Long.valueOf(half) - 1);

        if(prevHalf.length() >= len/2){
            String prevHalfReverse = new StringBuilder(prevHalf.substring(0, len/2)).reverse().toString();
            long l1 = Long.valueOf(prevHalf + prevHalfReverse);
            if(l1 != l){
                cands.add(l1);
            }
        }

        String halfReverse = new StringBuilder(half.substring(0, len/2)).reverse().toString();
        long l2 = Long.valueOf(half + halfReverse);

        String nextHalf = "" + (Long.valueOf(half) + 1);
        String nextHalfReverse = new StringBuilder(nextHalf.substring(0, len/2)).reverse().toString();
        long l3 = Long.valueOf(nextHalf + nextHalfReverse);

        if(l2 != l){
            cands.add(l2);
        }
        if(l3 != l){
            cands.add(l3);
        }
        long l4 = (long)Math.pow(10, len-1) - 1;
        if(l4 != l){
            cands.add(l4);
        }
        Collections.sort(cands);
        Long ans = 0l;
        long min = Long.MAX_VALUE;
        for(long cand: cands){
            if(Math.abs(l - cand) < min){
                min = Math.abs(l - cand);
                ans = cand;
            }
        }
        return "" + ans;
    }
}