class Solution:
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        needToFind = collections.Counter(t)
        hasFound = {}
        start = 0
        end = 0
        count = 0
        minSize = 2**31 -1
        res = ""
        while end < len(s):
            c = s[end]
            if c not in needToFind.keys():
                end += 1
                continue
            hasFound[c] = hasFound.get(c, 0) + 1
            if hasFound[c] <= needToFind[c]:
                count += 1
            if count == len(t):
                while s[start] not in needToFind.keys() or needToFind.get(s[start], 0) < hasFound[s[start]]:
                    if s[start] in needToFind.keys():
                        hasFound[s[start]] -= 1
                    start += 1
                if end - start + 1 < minSize:
                    minSize = end - start + 1
                    res = s[start:end+1]
            end += 1
        return res