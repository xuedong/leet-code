# The isBadVersion API is already defined for you.
# def isBadVersion(version: int) -> bool:

class Solution:
    def firstBadVersion(self, n: int) -> int:
        left, right = 1, n

        ans = -1
        while left <= right:
            mid = left + (right - left) // 2
            is_bad = isBadVersion(mid)

            if is_bad:
                ans = mid
                right = mid - 1
            else:
                left = mid + 1

        return ans

