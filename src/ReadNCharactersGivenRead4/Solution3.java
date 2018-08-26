/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    int total = 0;
    public int read(char[] buf, int n) {
        char[] buf4 = new char[4];
        while(n > 0){
            int realRead = read4(buf4);
            int newRead = Math.min(n, realRead);
            for(int i = 0; i < newRead; i++){
                buf[total++] = buf4[i];
            }
            if(realRead < 4) break;
            n -= realRead;
        }
        return total;
    }
}