import bisect


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        first, last = bisect.bisect_left(nums, target), bisect.bisect(nums, target)
        return [-1, -1] if first == last else [first, last-1]

