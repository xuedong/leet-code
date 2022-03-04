class Solution {
    fun champagneTower(poured: Int, query_row: Int, query_glass: Int): Double {
        var curr = DoubleArray(100) { 0.0 }
        curr[0] = poured.toDouble()
        
        for (i in 0..query_row-1) {
            val next = DoubleArray(100) { 0.0 }
            for (j in 0..99) {
                if (curr[j] > 1.0) {
                    val rest = curr[j] - 1.0
                    curr[j] = 1.0
                    next[j] += rest / 2.0
                    next[j+1] += rest / 2.0
                }
            }
            
            curr = next
        }
        
        return minOf(1.0, curr[query_glass])
    }
}

