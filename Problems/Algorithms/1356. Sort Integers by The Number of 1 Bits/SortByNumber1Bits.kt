class Solution {
    fun sortByBits(arr: IntArray): IntArray {
        return arr.toList().sortedWith(compareBy({ numberBits(it) }, { it })).toIntArray()
    }
    
    private fun numberBits(x: Int): Int {
        var ans = 0
        
        var curr = x
        while (curr > 0) {
            ans++
            curr = curr and (curr-1)
        }
        
        return ans
    }
}

