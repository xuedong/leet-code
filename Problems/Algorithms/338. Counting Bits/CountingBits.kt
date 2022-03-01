class Solution {
    fun countBits(n: Int): IntArray {
        return IntArray(n+1) { idx -> getBit(idx) }
    }
    
    private fun getBit(n: Int): Int {
        var count: Int = 0
        var num = n
        while (num > 0) {
            count++
            num = num and (num-1)
        }
        return count
    }
}

