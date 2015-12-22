class Solution(object):
    def bulbSwitch(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n <= 0: 
            return 0
            
        return int(math.sqrt(n))
        