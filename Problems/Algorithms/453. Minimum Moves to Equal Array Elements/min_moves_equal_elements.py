class Solution:
    def minMoves(self, nums: List[int]) -> int:
        minimum = min(nums)

        ans = 0
        for num in nums:
            ans += num - minimum

        return ans

