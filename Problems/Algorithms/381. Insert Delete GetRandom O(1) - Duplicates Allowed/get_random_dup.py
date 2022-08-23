#!/usr/bin/env python3

from collections import defaultdict
import random


class RandomizedCollection:

    def __init__(self):
        self.nums = []
        self.idx = defaultdict(set)

    def insert(self, val: int) -> bool:
        self.nums.append(val)
        self.idx[val].add(len(self.nums) - 1)
        return len(self.idx[val]) == 1

    def remove(self, val: int) -> bool:
        if not self.idx[val]:
            return False

        remove = self.idx[val].pop()
        last = self.nums[-1]
        self.nums[remove] = last
        self.idx[last].add(remove)
        self.idx[last].remove(len(self.nums) - 1)
        self.nums.pop()
        return True

    def getRandom(self) -> int:
        return self.nums[random.randint(0, len(self.nums) - 1)]


# Your RandomizedCollection object will be instantiated and called as such:
# obj = RandomizedCollection()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()