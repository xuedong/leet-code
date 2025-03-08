#!/usr/bin/env python3


class Solution:
    def minimumRecolors(self, blocks: str, k: int) -> int:
        whites = 0
        ans = float("inf")

        left = 0
        for right in range(len(blocks)):
            if blocks[right] == "W":
                whites += 1

            if right - left + 1 == k:
                ans = min(ans, whites)

                if blocks[left] == "W":
                    whites -= 1
                left += 1

        return ans
