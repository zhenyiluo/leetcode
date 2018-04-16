/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    int bufPtr = 0;
    int bufCount = 0;
    char[] buf4 = new char[4];
    public int read(char[] buf, int n) {
        int offset = 0;
        while(offset < n){
            if(bufPtr == 0){
                bufCount = read4(buf4);
            }
            if(bufCount == 0) break;
            while(offset < n && bufPtr < bufCount){
                buf[offset++] = buf4[bufPtr++];
            }
            if(bufPtr == bufCount) bufPtr = 0;
        }
        return offset;
    }
}