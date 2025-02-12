#!/usr/bin/env python3

from typing import List


class Solution:
    def __calculate(self, num):
        digit_sum = 0
        while num > 0:
            digit_sum += num % 10
            num //= 10
        return digit_sum

    def maximumSum(self, nums: List[int]) -> int:
        pairs = []
        for num in nums:
            digit_sum = self.__calculate(num)
            pairs.append((digit_sum, num))

        pairs.sort()

        ans = -1
        for i in range(1, len(pairs)):
            curr = pairs[i][0]
            prev = pairs[i-1][0]

            if curr == prev:
                curr_sum = pairs[i][1] + pairs[i-1][1]
                ans = max(ans, curr_sum)

        return ans
