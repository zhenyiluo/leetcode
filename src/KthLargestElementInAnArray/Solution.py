class Solution:
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        k = len(nums) - k
        left = 0
        right = len(nums) -1
        while left < right:
            p = self.partition(nums, left, right)
            if p < k:
                left = p + 1
            elif p > k:
                right = p - 1
            else:
                break
        return nums[k]

    def partition(self, nums, left, right):
        pivot = nums[left]
        i = left
        j = right + 1
        while True:
            while i < right and nums[i+1] < pivot:
                i += 1
            while j > left and nums[j-1] > pivot:
                j -= 1
            i += 1
            j -= 1
            if i >= j:
                break
            self.swap(nums, i, j)
        self.swap(nums, left, j)
        return j

    def swap(self, nums, i, j):
        tmp = nums[i]
        nums[i] = nums[j]
        nums[j] = tmp
