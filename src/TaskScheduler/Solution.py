class Solution:
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        taskCount = collections.Counter(tasks).values()
        M = max(taskCount)
        M_num = list(taskCount).count(M)
        return max(len(tasks), (M-1) * (n + 1) + M_num)
