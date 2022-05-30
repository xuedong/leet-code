/* The following solution will clearly incur TLE */
class Solution {
    fun divide(dividend: Int, divisor: Int): Int {
        if (dividend == 0) return 0
        
        val absDividend = Math.abs(dividend.toLong())
        val absDivisor = Math.abs(divisor.toLong())
        
        var rest = absDividend
        var ans = 0.toLong()
        while (rest >= absDivisor) {
            ans++
            rest -= absDivisor
        }
        
        if (divisor.toLong() * dividend.toLong() > 0) {
            if (ans > 2147483647) return 2147483647
            return ans.toInt()
        }
        
        if (ans > 2147483648) return -2147483648
        return -ans.toInt()
    }
}

