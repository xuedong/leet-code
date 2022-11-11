from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        ans = 0
        for i in range(len(nums)):
            if nums[i] != nums[ans]:
                ans += 1
                nums[ans] = nums[i]
        return ans + 1
