#!/usr/bin/env python3

from typing import List


class Solution:
    def minOperations(self, logs: List[str]) -> int:
        depth = 0

        for curr in logs:
            if curr == "../":
                depth = max(0, depth-1)
            elif curr != "./":
                depth += 1

        return depth
