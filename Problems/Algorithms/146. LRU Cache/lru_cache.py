#!/usr/bin/env python3


class Node:
    def __init__(self, key: int, value: int):
        self.key, self.value = key, value
        self.prev, self.next = None, None


class LRUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.cache = dict()
        
        self._sentinel = Node(-1, -1)
        self._sentinel.next = self._sentinel.prev = self._sentinel

    def _remove(self, node: Node):
        prev, next = node.prev, node.next
        prev.next = next
        next.prev = prev

    def _insert(self, node: Node):
        prev = self._sentinel.prev
        prev.next = node
        node.next = self._sentinel
        node.prev = prev
        self._sentinel.prev = node

    def get(self, key: int) -> int:
        if key in self.cache:
            node = self.cache[key]
            self._remove(node)
            self._insert(node)
            return node.value
        return -1

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            self._remove(self.cache[key])
        node = Node(key, value)
        self._insert(node)
        self.cache[key] = node

        if len(self.cache) > self.capacity:
            node = self._sentinel.next
            self._remove(node)
            del self.cache[node.key]


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)