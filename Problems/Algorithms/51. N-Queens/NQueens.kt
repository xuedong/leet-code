class Solution {
    private val results: MutableList<List<Int>>
    
    init {
        results = mutableListOf()
    }
    
    fun solveNQueens(n: Int): List<List<String>> {
        dfs(n, listOf(), listOf(), listOf())
        
        val outputs: MutableList<MutableList<String>> = mutableListOf()
        for (result in results) {
            val output: MutableList<String> = mutableListOf()
            for (i in 0..n-1) {
                val sb = StringBuilder()
                for (j in 0..n-1) {
                    if (result[i] == j) {
                        sb.append("Q")
                    } else {
                        sb.append(".")
                    }
                }
                output.add(sb.toString())
            }
            outputs.add(output)
        }
        return outputs
    }
    
    private fun dfs(n: Int, queens: List<Int>, diagPos: List<Int>, diagNeg: List<Int>) {
        val p = queens.size
        if (p == n) {
            results.add(queens)
            return
        }
        
        for (q in 0..n-1) {
            if (!queens.contains(q) && !diagPos.contains(p-q) && !diagNeg.contains(p+q)) {
                dfs(n, queens + listOf(q), diagPos + listOf(p-q), diagNeg + listOf(p+q))
            }
        }
    }
}

