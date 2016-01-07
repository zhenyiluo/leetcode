// RK algorithm
import java.math.BigInteger;
import java.util.Random;

public class Solution1 {
    public static final int D = 256;

    public static void main(String[] args) {
        String needle = "abab";
        String haystack = "aaaabab";
        System.out.println(new Solution().strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || needle.length() > haystack.length()) {
            return -1;
        }
        if(needle.length() == 0) {
            return 0;
        }
        char[] s = haystack.toCharArray();
        char[] p = needle.toCharArray();
        int q = BigInteger.probablePrime(15, new Random()).intValue();
        // int q = 101
        return rkSearch(s, p, q);
    }

    public int rkSearch(char[] txt, char[] pat, int q) {
        int M = pat.length;
        int N = txt.length;
        int i, j;
        int p = 0;
        int t = 0;
        int h = 1;

        for (i = 0; i < M - 1; i++) {
            h = (h * D) % q;
        }

        for (i = 0; i < M; i++) {
            p = (D * p + pat[i]) % q;
            t = (D * t + txt[i]) % q;
        }

        for (i = 0; i <= N - M; i++) {
            if (p == t) {
                for (j = 0; j < M; j++) {
                    if (txt[i + j] != pat[j]) {
                        break;
                    }
                }

                if (j == M) {
                    return i;
                }
            }

            if (i < N - M) {
                t = (D * (t - txt[i] * h) + txt[i + M]) % q;
                if (t < 0) {
                    t = t + q;
                }
            }
        }
        return -1;
    }
}