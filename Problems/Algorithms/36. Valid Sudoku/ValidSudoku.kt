class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        for (i in 0..8) {
            if (!isValidRow(board, i)) return false
            if (!isValidCol(board, i)) return false
            if (!isValidBox(board, i)) return false
        }
        
        return true
    }
    
    private fun isValidRow(board: Array<CharArray>, row: Int): Boolean {
        val map: MutableMap<Char, Int> = mutableMapOf<Char, Int>()
        for (j in 0..8) {
            val ch = board[row][j]
            if (ch != '.') {
                if (map.containsKey(ch)) return false
                map[ch] = 1
            }
        }
        
        return true
    }
    
    private fun isValidCol(board: Array<CharArray>, col: Int): Boolean {
        val map: MutableMap<Char, Int> = mutableMapOf<Char, Int>()
        for (i in 0..8) {
            val ch = board[i][col]
            if (ch != '.') {
                if (map.containsKey(ch)) return false
                map[ch] = 1
            }
        }
        
        return true
    }
    
    private fun isValidBox(board: Array<CharArray>, box: Int): Boolean {
        val map: MutableMap<Char, Int> = mutableMapOf<Char, Int>()
        for (i in 0..2) {
            for (j in 0..2) {
                val ch = board[box/3*3+i][box%3*3+j]
                if (ch != '.') {
                    if (map.containsKey(ch)) return false
                    map[ch] = 1
                }
            }
        }
        
        return true
    }
}

