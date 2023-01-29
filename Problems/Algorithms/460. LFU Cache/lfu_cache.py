#!/usr/bin/env python3

from collections import defaultdict


class Node:
    def __init__(self, key: int, value: int):
        self.key, self.value = key, value
        self.freq = 1
        self.prev = self.next = None


class DoublyLinkedList:
    def __init__(self):
        self._sentinel = Node(-1, -1)
        self._sentinel.next = self._sentinel.prev = self._sentinel
        self._size = 0

    def __len__(self):
        return self._size

    def append(self, node: Node):
        node.next = self._sentinel.next
        node.prev = self._sentinel
        self._sentinel.next.prev = node
        self._sentinel.next = node
        self._size += 1
    
    def pop(self, node: Node = None):
        if self._size == 0:
            return
        
        if not node:
            node = self._sentinel.prev
        node.prev.next = node.next
        node.next.prev = node.prev
        self._size -= 1
        return node


class LFUCache:
    def __init__(self, capacity: int):
        self.size = 0
        self.capacity = capacity
        
        self.cache = dict()
        self.freq = defaultdict(DoublyLinkedList)
        self.min_freq = 0

    def _update(self, node: Node):
        old_freq = node.freq
        
        self.freq[old_freq].pop(node)
        if self.min_freq == old_freq and len(self.freq[old_freq]) == 0:
            self.min_freq += 1
        
        node.freq += 1
        new_freq = node.freq
        self.freq[new_freq].append(node)

    def get(self, key: int) -> int:
        if key in self.cache:
            node = self.cache[key]
            self._update(node)
            return node.value
        return -1

    def put(self, key: int, value: int) -> None:
        if self.capacity == 0:
            return

        if key in self.cache:
            node = self.cache[key]
            self._update(node)
            node.value = value
        else:
            if self.size == self.capacity:
                node = self.freq[self.min_freq].pop()
                del self.cache[node.key]
                self.size -= 1
                
            node = Node(key, value)
            self.cache[key] = node
            self.freq[1].append(node)
            self.min_freq = 1
            self.size += 1


# Your LFUCache object will be instantiated and called as such:
# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)