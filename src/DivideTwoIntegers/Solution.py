class Solution:
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        if dividend == -2**31 and divisor == -1:
            return 2**31 -1
        negative = (dividend < 0) ^ (divisor < 0)
        div = abs(dividend)
        dvs = abs(divisor)
        ans = 0
        while div >= dvs:
            tmp = dvs
            mul = 1
            while(div >= (tmp << 1)):
                tmp <<= 1
                mul <<= 1
            ans += mul
            div -= tmp
        return -ans if negative else ans
        