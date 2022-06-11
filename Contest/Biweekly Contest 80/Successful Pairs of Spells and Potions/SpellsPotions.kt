class Solution {
    fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
        val n = spells.size
        val m = potions.size
        
        potions.sort()
        
        val results = IntArray(n) { 0 }
        for (i in 0..n-1) {
            var left = 0
            var right = m - 1
            
            while (left <= right) {
                val mid = left + (right - left) / 2
                
                if (spells[i].toLong() * potions[mid].toLong() >= success) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
            
            results[i] = m - left
        }
        
        return results
    }
}

