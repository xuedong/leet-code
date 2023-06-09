#!/usr/bin/env python3

from typing import List


class Solution:
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        left, right = -1, len(letters)

        while right - left > 1:
            mid = left + (right - left) // 2
            if letters[mid] <= target:
                left = mid
            else:
                right = mid

        return letters[right] if right < len(letters) else letters[0]
