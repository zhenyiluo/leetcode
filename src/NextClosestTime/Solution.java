class Solution {
    static int[] mins = {600, 60, 10, 1};
    public String nextClosestTime(String time) {
        int index = time.indexOf(":");
        int cur = Integer.valueOf(time.substring(0, index)) * 60 + Integer.valueOf(time.substring(index+1));
        char[] next = new char[4];
        for(int i = 1; i <= 1440; i ++){
            int d = 0;
            int m = (cur + i) % 1440;
            for(; d < 4; d++){
                next[d] = (char) ('0' + m / mins[d]);
                m %= mins[d];
                if(time.indexOf(next[d])==-1) break;
            }
            if(d == 4) break;
        }
        return new String(next, 0, 2) + ":" + new String(next, 2, 2);
    }
}