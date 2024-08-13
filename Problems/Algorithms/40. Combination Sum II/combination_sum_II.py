#!/usr/bin/env python3

from typing import List


class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()

        ans = []
        self.backtrack(candidates, target, 0, [], ans)
        return ans

    def backtrack(self, candidates, target, start, curr, ans):
        if target < 0:
            return

        if target == 0:
            ans.append(curr)
            return

        for i in range(start, len(candidates)):
            if i > start and candidates[i] == candidates[i-1]:
                continue

            self.backtrack(candidates, target - candidates[i], i+1, curr + [candidates[i]], ans)
