class Solution {

    private val mod = 1000000007

    fun numberOfWays(startPos: Int, endPos: Int, k: Int): Int {
        var start = startPos
        var end = endPos
        if (start > end) {
            start = endPos
            end = startPos
        }
        
        val diff = end - start
        if (diff > k || (diff - k) % 2 == 1) {
            return 0
        }

        return nCr((diff+k)/2, k)
    }

    private fun inv(a: Long): Long {
        if (a == 1) return 1
        return (mod - mod / a) * inv(mod % a) % mod
    }

    private fun nCr(k: Int, n: Int): Int {
        var result = 1.toLong()
        for (i in 1..k) {
            result = result * (n - i + 1) % mod
            result = result * inv(i) % mod
        }
        return result.toInt()
    }
}
