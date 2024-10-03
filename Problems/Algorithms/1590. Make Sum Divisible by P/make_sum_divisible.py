#!/usr/bin/env python3

from typing import List


class Solution:
    def minSubarray(self, nums: List[int], p: int) -> int:
        n = len(nums)
        total = 0

        for num in nums:
            total = (total + num) % p

        target = total % p
        if target == 0:
            return 0

        mods = {0: -1}
        curr = 0
        ans = n
        for i in range(n):
            curr = (curr + nums[i]) % p
            needed = (curr - target + p) % p

            if needed in mods:
                ans = min(ans, i - mods[needed])

            mods[curr] = i

        return -1 if ans == n else ans
