public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || needle.length() > haystack.length()) {
            return -1;
        }
        if(needle.length() == 0) {
            return 0;
        }
        char[] s = haystack.toCharArray();
        char[] p = needle.toCharArray();
        next = new int[p.length];
        buildNext(p, next);
        return kmpSearch(s, p);
    }

    int[] next;
    private void buildNext(char[] p, int[] next) {
        next[0] = -1;
        int k = -1;
        int j = 0;
        while(j < p.length - 1) {
            if(k == -1 || p[j] == p[k]) {
                j ++;
                k ++;
                if(p[j] != p[k]) {
                    next[j] = k;
                } else{
                    next[j] = next[k];
                }
            }else {
                k = next[k];
            }
        }
    }

    private int kmpSearch(char[] s, char[] p) {
        int i = 0;
        int j = 0;
        while(i < s.length && j < p.length) {
            if(j == -1 || s[i] == p[j]) {
                i++;
                j++;
            } else{
                j = next[j];
            }
        }
        if (j == p.length) {
            return i - j;
        } else {
            return -1;
        }
    }
}