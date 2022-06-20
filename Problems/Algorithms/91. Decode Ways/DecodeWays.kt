class Solution {
    fun numDecodings(s: String): Int {
        val n = s.length
        val dp = IntArray(n+1)
        if (s.get(0) == '0') return 0
        if (n == 1) return 1
        
        dp[0] = 1
        dp[1] = 1
        for (i in 2..n) {
            if (s.get(i-2) == '1' || s.get(i-2) == '2' && s.get(i-1) <= '6') {
                if (s.get(i-1) == '0') {
                    dp[i] = dp[i-2]
                } else {
                    dp[i] = dp[i-2] + dp[i-1]
                }
            } else if ((s.get(i-2) == '0' || s.get(i-2) > '2') && s.get(i-1) == '0') {
                return 0
            } else {
                dp[i] = dp[i-1]
            }
        }
        
        return dp[n]
    }
}

