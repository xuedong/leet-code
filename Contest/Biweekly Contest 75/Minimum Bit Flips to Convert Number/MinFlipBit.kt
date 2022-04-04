class Solution {
    fun minBitFlips(start: Int, goal: Int): Int {
        return countBits(start xor goal)
    }
    
    private fun countBits(num: Int): Int {
        var count = 0
        
        var n = num
        while (n != 0) {
            count++
            n = n and (n-1)
        }
        
        return count
    }
}

