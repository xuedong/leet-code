class Solution {
    private var ans = 0
    
    fun totalNQueens(n: Int): Int {
        dfs(n, listOf(), listOf(), listOf())
        
        return ans
    }
    
    private fun dfs(n: Int, queens: List<Int>, diagPos: List<Int>, diagNeg: List<Int>) {
        val p = queens.size
        if (p == n) {
            ans++
            return
        }
        
        for (q in 0..n-1) {
            if (!queens.contains(q) && !diagPos.contains(p-q) && !diagNeg.contains(p+q)) {
                dfs(n, queens + listOf(q), diagPos + listOf(p-q), diagNeg + listOf(p+q))
            }
        }
    }
}

