class Solution {
    public int superpalindromesInRange(String L, String R) {
        long l = Long.valueOf(L);
        long r = Long.valueOf(R);
        int ans = 0;
        for(long i = (long) Math.sqrt(l); i * i <= r;){
            long p = nextP(i);
            if(p * p <= r && isPalindrome(p*p)){
                ans ++;
            }
            i = p + 1;
        }
        return ans;
    }

    private long nextP(long l){
        String s = "" + l;
        String half = s.substring(0, (s.length() + 1) / 2);
        String reverseHalf = new StringBuilder(half.substring(0, s.length() / 2)).reverse().toString();
        String nextHalf = "" + (Long.valueOf(half) + 1);
        String reverseNextHalf = new StringBuilder(nextHalf.substring(0, s.length()/2)).reverse().toString();
        List<Long> list = new ArrayList<>();
        list.add(Long.valueOf(half + reverseHalf));
        list.add(Long.valueOf(nextHalf + reverseNextHalf));
        long min = Long.MAX_VALUE;
        for(long val: list){
            if(val >= l){
                min = Math.min(val, min);
            }
        }
        return min;
    }

    private boolean isPalindrome(long l){
        String s = "" + l;
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}