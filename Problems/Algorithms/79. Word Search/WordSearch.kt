class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val n = board.size
        val m = board[0].size

        val neighbors = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
        val visited = Array(n) { BooleanArray(m) { false } }
        
        for (i in 0..n-1) {
            for (j in 0..m-1) {
                if (aux(board, neighbors, visited, i, j, word)) return true
            }
        }
        return false
    }
    
    private fun aux(board: Array<CharArray>, neighbors: Array<IntArray>, visited: Array<BooleanArray>, i: Int, j: Int, word: String): Boolean {
        if (word.length == 1) return board[i][j] == word.get(0)
        
        visited[i][j] = true
        var ans = false
        if (board[i][j] == word.get(0)) {
            ans = neighbors.filter { isValid(board, visited, i+it[0], j+it[1]) }
                .any { aux(board, neighbors, visited, i+it[0], j+it[1], word.substring(1)) }
        }
        visited[i][j] = false
        
        return ans
    }
    
    private fun isValid(board: Array<CharArray>, visited: Array<BooleanArray>, i: Int, j: Int): Boolean {
        val n = board.size
        val m = board[0].size
        return i >= 0 && i < n && j >= 0 && j < m && !visited[i][j]
    }
}

