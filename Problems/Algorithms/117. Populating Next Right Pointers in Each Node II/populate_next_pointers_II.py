"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root: return None

        node = root
        while node:
            self.link_children(node)
            node = node.next

        self.connect(root.left)
        self.connect(root.right)

        return root

    def find_next(self, node: 'Node') -> 'Node':
        if not node: return None

        next = node.next
        while next:
            if next.left: return next.left
            if next.right: return next.right
            next = next.next

        return None

    def link_children(self, node: 'Node'):
        if not node: return

        if node.left:
            node.left.next = node.right if node.right else self.find_next(node)

        if node.right:
            node.right.next = self.find_next(node)

