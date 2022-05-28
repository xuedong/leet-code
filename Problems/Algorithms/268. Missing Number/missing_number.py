class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        ans = 0

        for num in nums:
            ans ^= num

        for num in range(len(nums)+1):
            ans ^= num

        return ans

