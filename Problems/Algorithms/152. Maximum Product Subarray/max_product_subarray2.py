class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        prefix = nums
        suffix = nums[::-1]
        for i in range(1, len(nums)):
            prefix[i] *= prefix[i - 1] or 1
            suffix[i] *= suffix[i - 1] or 1
        return max(prefix + suffix)

