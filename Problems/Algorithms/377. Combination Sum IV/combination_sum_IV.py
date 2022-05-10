class Solution:
    def combinationSum4(self, nums: List[int], target: int) -> int:
        dp = []

        while len(dp) < target:
            dp.append(0)

            for num in nums:
                curr = len(dp)
                if num == curr:
                    dp[-1] += 1
                elif num < curr:
                    dp[-1] += dp[curr-num-1]

        return dp[-1]

