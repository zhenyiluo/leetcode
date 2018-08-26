/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    char[] buf4 = new char[4];
    int buf4Ptr = 0;
    int buf4Size = 0;
    public int read(char[] buf, int n) {
        int total = 0;
        while(n > 0){
            if(buf4Ptr < buf4Size){
                buf[total++] = buf4[buf4Ptr++];
                n--;
            }else{
                buf4Ptr = 0;
                buf4Size = read4(buf4);
                if(buf4Size == 0) break;
            }
        }
        return total;
    }
}