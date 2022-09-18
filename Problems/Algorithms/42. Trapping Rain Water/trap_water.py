#!/usr/bin/env python3

from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        ans, id, stack = 0, 0, []
        while id < len(height):
            while (stack and height[id] > height[stack[-1]]):
                last = stack.pop()
                if not stack:
                    break

                distance = id - stack[-1] - 1
                bounded_height = min(height[id], height[stack[-1]]) - height[last]
                ans += distance * bounded_height
            stack.append(id)
            id += 1

        return ans
