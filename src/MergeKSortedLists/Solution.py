# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
from queue import PriorityQueue
class Solution:
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        q = PriorityQueue()
        dummy = ListNode(None)
        cur = dummy
        for idx, node in enumerate(lists):
            if node: q.put((node.val, idx, node))
        while not q.empty():
            item = q.get()
            cur.next, idx = item[2], item[1]
            cur = cur.next
            node = cur.next
            if node: q.put((node.val, idx, node))
        return dummy.next