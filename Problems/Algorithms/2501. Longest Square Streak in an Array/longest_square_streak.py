#!/usr/bin/env python3

from typing import List


class Solution:
    def longestSquareStreak(self, nums: List[int]) -> int:
        longest_streak = 0
        unique_numbers = set(nums)

        for start in nums:
            curr_streak = 0
            curr = start

            while curr in unique_numbers:
                curr_streak += 1
                if curr * curr > 10 ** 5:
                    break

                curr *= curr

            longest_streak = max(longest_streak, curr_streak)

        return longest_streak if longest_streak >= 2 else -1
