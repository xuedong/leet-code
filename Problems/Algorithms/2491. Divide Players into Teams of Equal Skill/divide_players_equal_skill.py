#!/usr/bin/env python3

from typing import List


class Solution:
    def dividePlayers(self, skill: List[int]) -> int:
        skill.sort()

        total, target = 0, skill[0] + skill[-1]
        n = len(skill)
        for i in range(n//2):
            if skill[i] + skill[-i-1] != target:
                return -1

            total += skill[i] * skill[-i-1]

        return total
