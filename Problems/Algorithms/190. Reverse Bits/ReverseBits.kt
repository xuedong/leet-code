class Solution {
    // you need treat n as an unsigned value
    fun reverseBits(n: Int): Int {
        var curr = n
        var ans = 0
        
        for (i in 0..31) {
            ans = (ans shl 1)
            ans = (ans or (curr and 1))
            curr = (curr shr 1)
        }
        
        return ans
    }
}

