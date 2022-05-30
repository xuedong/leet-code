class Solution {
    fun divide(dividend: Int, divisor: Int): Int {
        if (dividend == 1 shl 31 && divisor == -1) return (1 shl 31) - 1
        
        val sign = if ((dividend < 0) xor (divisor < 0)) -1 else 1
        
        val absDividend = Math.abs(dividend.toLong())
        val absDivisor = Math.abs(divisor.toLong())
        
        var rest = absDividend
        var ans = 0
        for (shift in 31 downTo 0) {
            if ((rest shr shift) >= absDivisor) {
                ans += (1 shl shift)
                rest -= (absDivisor shl shift)
            }
        }
        
        return if (sign == 1) ans else -ans
    }
}

