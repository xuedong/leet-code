#!/usr/bin/env python3

import random


class RandomizedSet:

    def __init__(self):
        self.nums = []
        self.idx = {}

    def insert(self, val: int) -> bool:
        if val not in self.idx:
            self.nums.append(val)
            self.idx[val] = len(self.nums) - 1
            return True
        return False

    def remove(self, val: int) -> bool:
        if val in self.idx:
            idx, tail = self.idx[val], self.nums[-1]
            self.nums[idx], self.idx[tail] = tail, idx
            self.nums.pop()
            self.idx.pop(val)
            return True
        return False

    def getRandom(self) -> int:
        return self.nums[random.randint(0, len(self.nums) - 1)]


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()