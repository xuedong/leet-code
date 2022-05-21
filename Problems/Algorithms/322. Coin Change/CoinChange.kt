class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount+1) { -1 }
        dp[0] = 0
        
        coins.sort()
        for (i in 1..amount) {
            for (coin in coins) {
                if (i == coin) {
                    dp[i] = 1
                    break
                } else if (i > coin) {
                    val temp = if (dp[i-coin] == -1) -1 else dp[i-coin] + 1
                    dp[i] = if (dp[i] == -1) temp else if (temp != -1) minOf(dp[i], temp) else dp[i]
                }
            }
        }
        
        return dp[amount]
    }
}

