import bisect


class Solution:
    def maxDistance(self, nums1: List[int], nums2: List[int]) -> int:
        nums2 = list(map(lambda x: -x, nums2))

        ans = 0
        for i, num in enumerate(nums1):
            j = bisect.bisect_right(nums2, -num)
            ans = max(ans, j-i-1)

        return ans

