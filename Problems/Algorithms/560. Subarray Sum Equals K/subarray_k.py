#!/usr/bin/env python3

from collections import defaultdict


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        dictionary = defaultdict(int)
        dictionary[0] = 1

        ans, prefix = 0, 0
        for i in range(len(nums)):
            prefix += nums[i]
            if prefix-k in dictionary {
                ans += dictionary[prefix-k]
            }
            dictionary[prefix] += 1
        }

        return ans

