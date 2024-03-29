#!/usr/bin/env python3

from heapq import heappush, heappop
from typing import List


class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        m, n = len(nums1), len(nums2)

        ans = []
        visited = set()

        hp = [(nums1[0] + nums2[0], (0, 0))]
        visited.add((0, 0))
        count = 0

        while k > 0 and hp:
            val, (i, j) = heappop(hp)
            ans.append([nums1[i], nums2[j]])

            if i + 1 < m and (i + 1, j) not in visited:
                heappush(hp, (nums1[i+1] + nums2[j], (i+1, j)))
                visited.add((i+1, j))

            if j + 1 < n and (i, j + 1) not in visited:
                heappush(hp, (nums1[i] + nums2[j+1], (i, j+1)))
                visited.add((i, j+1))

            k -= 1

        return ans
