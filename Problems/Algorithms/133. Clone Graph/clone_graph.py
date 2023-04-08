from collections import deque


# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []


class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return node

        queue = deque([node])
        cloned = {node.val: Node(node.val, [])}
        while queue:
            curr = queue.popleft()

            for neighbor in curr.neighbors:
                if neighbor.val not in cloned:
                    cloned[neighbor.val] = Node(neighbor.val, [])
                    queue.append(neighbor)

                cloned[curr.val].neighbors.append(cloned[neighbor.val])

        return cloned[node.val]
