#!/usr/bin/env python3

from typing import List


class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        prefix_mod = 0
        mod_seen = {0: -1}

        for i in range(len(nums)):
            prefix_mod = (prefix_mod + nums[i]) % k

            if prefix_mod in mod_seen:
                if i - mod_seen[prefix_mod] > 1:
                    return True
            else:
                mod_seen[prefix_mod] = i

        return False
