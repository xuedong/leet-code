#!/usr/bin/env python3

import math
from typing import List


class Solution:
    def minimizeArrayValue(self, nums: List[int]) -> int:
        ans, prefix = 0, 0

        for i in range(len(nums)):
            prefix += nums[i]
            ans = max(ans, math.ceil(prefix / (i + 1)))

        return ans
