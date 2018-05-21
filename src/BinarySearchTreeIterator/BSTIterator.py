# Definition for a  binary tree node
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class BSTIterator(object):
    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.stack = []
        self.pushAll(self.stack, root)

    def pushAll(self, stack, node):
        while node:
            self.stack.append(node)
            node = node.left


    def hasNext(self):
        """
        :rtype: bool
        """
        return self.stack


    def next(self):
        """
        :rtype: int
        """
        node = self.stack.pop()
        self.pushAll(self.stack, node.right)
        return node.val


# Your BSTIterator will be called like this:
# i, v = BSTIterator(root), []
# while i.hasNext(): v.append(i.next())