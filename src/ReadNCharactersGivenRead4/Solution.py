# The read4 API is already defined for you.
# @param buf, a list of characters
# @return an integer
# def read4(buf):

class Solution(object):
    def read(self, buf, n):
        """
        :type buf: Destination buffer (List[str])
        :type n: Maximum number of characters to read (int)
        :rtype: The number of characters read (int)
        """
        bufPtr = 0
        offset = 0
        buf4 = [""] * 4
        while offset < n:
            bufCount = read4(buf4)
            if bufCount == 0: break
            while offset < n and bufPtr < bufCount:
                buf[offset] = buf4[bufPtr]
                offset += 1
                bufPtr += 1
            if bufPtr == bufCount: bufPtr = 0
        return offset