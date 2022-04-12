class Solution {
    fun gameOfLife(board: Array<IntArray>): Unit {
        val n = board.size
        val m = board[0].size
        play(board, n, m)
        update(board, n, m)
    }
    
    private fun countNeighbors(board: Array<IntArray>, i: Int, j: Int, n: Int, m: Int): Int {
        var alive = 0
        for (x in -1..1) {
            for (y in -1..1) {
                if (x == 0 && y == 0) continue
                if (isValid(i+x, j+y, n, m)) {
                    alive += (board[i+x][j+y] and 1)
                }
            }
        }
        
        return alive
    }
    
    private fun isValid(i: Int, j: Int, n: Int, m: Int): Boolean {
	    return i >= 0 && i < n && j >= 0 && j < m
    }
    
    private fun update(board: Array<IntArray>, n: Int, m: Int): Unit {
        for (i in 0..n-1) {
            for (j in 0..m-1) {
                board[i][j] = (board[i][j] shr 1)
            }
        }
    }
    
    private fun play(board: Array<IntArray>, n: Int, m: Int): Unit {
	    for (i in 0..n-1) {
		    for (j in 0..m-1) {
			    val alive = countNeighbors(board, i, j, n, m)
			    if (board[i][j] == 0 && alive == 3) {
                    board[i][j] = 2
                } else if (board[i][j] == 1 && (alive == 2 || alive == 3)) {
				    board[i][j] = 3
                }
            }
        }
    }
}

