class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [-1] * (amount+1)
        dp[0] = 0

        for i in range(1, amount+1):
            curr = [dp[i-j] for j in coins if j <= i and dp[i-j] != -1]
            if curr:
                dp[i] = min(curr) + 1

        return dp[amount]

