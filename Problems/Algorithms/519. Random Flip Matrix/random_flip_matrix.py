#!/usr/bin/env python3

import random
from typing import List


class Solution:

    def __init__(self, m: int, n: int):
        self.col = n
        self.row = m
        self.last = m * n - 1
        self.map = {}

    def flip(self) -> List[int]:
        rand_idx = random.randint(0, self.last)
        target_idx = self.map.get(rand_idx, rand_idx)
        self.map[rand_idx] = self.map.get(self.last, self.last)
        self.last -= 1

        row = target_idx // self.col
        col = target_idx % self.col
        return [row, col]

    def reset(self) -> None:
        self.map = {}
        self.last = self.row * self.col - 1


# Your Solution object will be instantiated and called as such:
# obj = Solution(m, n)
# param_1 = obj.flip()
# obj.reset()