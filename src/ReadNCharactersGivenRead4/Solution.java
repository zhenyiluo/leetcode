/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int offset = 0;
        int cur = 0;
        char[] buf4 = new char[4];
        while (n > 0 && (cur = read4(buf4)) > 0){
            for(int i = 0; i < Math.min(cur, n); i++){
                buf[offset++] = buf4[i];
            }
            n -= cur;
        }
        return offset;
    }
}