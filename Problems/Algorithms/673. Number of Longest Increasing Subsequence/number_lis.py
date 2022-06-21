class Solution:
    def findNumberOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        lengths, counts = [1] * n, [1] * n

        ans, best = 0, 0
        for i in range(n):
            for j in range(i):
                if nums[i] > nums[j]:
                    if lengths[i] == lengths[j] + 1:
                        counts[i] += counts[j]
                    elif lengths[i] < lengths[j] + 1:
                        lengths[i] = lengths[j] + 1
                        counts[i] = counts[j]

            if best == lengths[i]:
                ans += counts[i]
            elif best < lengths[i]:
                best = lengths[i]
                ans = counts[i]

        return ans

