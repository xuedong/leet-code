#!/usr/bin/env python3

from copy import copy
from typing import List


class Solution:
    def __init__(self) -> None:
        self.results = []
        self.curr = []

    def numsSameConsecDiff(self, n: int, k: int) -> List[int]:
        self.helper(n, k)
        return self.results

    def helper(self, n: int, k: int):
        if len(self.curr) == n:
            self.results.append(int(''.join(copy(self.curr))))
            return

        for i in range(10):
            if len(self.curr) == 0 and i > 0 or len(self.curr) > 0 and abs(int(self.curr[-1]) - i) == k:
                self.curr.append(str(i))
                self.helper(n, k)
                self.curr.pop()
