class Solution:
    def multiply(self, A, B):
        """
        :type A: List[List[int]]
        :type B: List[List[int]]
        :rtype: List[List[int]]
        """
        if not A or not B or len(A) == 0 or len(A[0]) == 0 or len(B) == 0 or len(B[0]) == 0:
            return [0][0]

        mA = len(A)
        nA = len(A[0])
        mB = len(B)
        nB = len(B[0])
        ret = [[0 for i in range(nB)] for j in range(mA)]

        listA = [[] for i in range(nA)]
        listB = [[] for i in range(mB)]
        for j in range(nA):
            for i in range(mA):
                if A[i][j] != 0:
                    listA[j].append((A[i][j], i))

        for i in range(mB):
            for j in range(nB):
                if B[i][j] != 0:
                    listB[i].append((B[i][j], j))

        for i in range(nA):
            list1 = listA[i]
            list2 = listB[i]
            for val1, idx1 in list1:
                for val2, idx2 in list2:
                    ret[idx1][idx2] += val1 * val2

        return ret;
                    