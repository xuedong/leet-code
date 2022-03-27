class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) return s
        
        val rows = Array(numRows) { StringBuilder() }
        val n = 2 * numRows - 2
        
        for (i in 0..s.length-1) {
            val p = i % n
            val row = when {
                p < numRows -> p
                else -> n - p
            }
            rows[row].append(s.get(i))
        }
        
        return rows.joinToString("")
    }
}

