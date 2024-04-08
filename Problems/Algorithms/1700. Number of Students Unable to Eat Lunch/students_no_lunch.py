#!/usr/bin/env python3

from typing import List


class Solution:
    def countStudents(self, students: List[int], sandwiches: List[int]) -> int:
        counts = [0, 0]
        for student in students:
            counts[student] += 1

        ans = len(sandwiches)
        for sandwich in sandwiches:
            if counts[sandwich] == 0:
                break
            if ans == 0:
                break

            counts[sandwich] -= 1
            ans -= 1

        return ans
