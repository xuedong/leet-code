#!/usr/bin/env python3

from typing import List
from collections import deque


class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        next_slot = {
            "0": "1",
            "1": "2",
            "2": "3",
            "3": "4",
            "4": "5",
            "5": "6",
            "6": "7",
            "7": "8",
            "8": "9",
            "9": "0",
        }
        prev_slot = {
            "0": "9",
            "1": "0",
            "2": "1",
            "3": "2",
            "4": "3",
            "5": "4",
            "6": "5",
            "7": "6",
            "8": "7",
            "9": "8",
        }

        visited = set(deadends)
        if "0000" in visited:
            return -1
        visited.add("0000")

        dq = deque()
        turns = 0

        dq.append("0000")
        while dq:
            size = len(dq)
            for _ in range(size):
                curr = dq.popleft()
                if curr == target:
                    return turns

                for wheel in range(4):
                    new = list(curr)
                    new[wheel] = next_slot[new[wheel]]
                    new_str = "".join(new)

                    if new_str not in visited:
                        dq.append(new_str)
                        visited.add(new_str)

                    new = list(curr)
                    new[wheel] = prev_slot[new[wheel]]
                    new_str = "".join(new)

                    if new_str not in visited:
                        dq.append(new_str)
                        visited.add(new_str)

            turns += 1

        return -1
