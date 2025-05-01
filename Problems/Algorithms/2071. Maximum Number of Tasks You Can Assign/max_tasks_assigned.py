#!/usr/bin/env python3

from typing import List
from sortedcontainers import SortedList


class Solution:
    def maxTaskAssign(self, tasks: List[int], workers: List[int], pills: int, strength: int) -> int:
        n, m = len(tasks), len(workers)
        tasks.sort()
        workers.sort()

        def check(mid: int) -> bool:
            curr_pills = pills
            curr_workers = SortedList(workers[m-mid:])

            for i in range(mid-1, -1, -1):
                if curr_workers[-1] >= tasks[i]:
                    curr_workers.pop()
                else:
                    if curr_pills == 0:
                        return False
                    
                    rep = curr_workers.bisect_left(tasks[i] - strength)
                    if rep == len(curr_workers):
                        return False

                    curr_pills -= 1
                    curr_workers.pop(rep)
            return True

        left, right = 0, min(m, n) + 1
        ans = 0
        while right - left > 1:
            mid = left + (right - left) // 2
            if check(mid):
                ans = mid
                left = mid
            else:
                right = mid

        return ans
