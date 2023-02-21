class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        left, right = -1, len(nums)
        while right - left > 1:
            mid = left + (right - left) // 2
            if (mid % 2 == 1 and nums[mid + 1] == nums[mid]) or (mid % 2 == 0 and nums[mid] == nums[mid - 1]):
                right = mid
            else:
                left = mid

        return nums[left]
