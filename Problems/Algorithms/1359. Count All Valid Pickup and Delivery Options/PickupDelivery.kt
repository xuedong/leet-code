class Solution {
    val modulo = (Math.pow(10.0, 9.0) + 7.0).toInt()
    
    fun countOrders(n: Int): Int {
        val dp: LongArray = LongArray(n) { 0 }
        
        dp[0] = 1.toLong()
        for (i in 1 until n) {
            dp[i] = (2*i*i + 3*i + 1) * dp[i-1] % modulo
        }
        
        return dp[n-1].toInt()
    }
}

