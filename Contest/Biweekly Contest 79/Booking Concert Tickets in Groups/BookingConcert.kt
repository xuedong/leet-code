/* The following code gets TLE for the last cases */
class BookMyShow(n: Int, m: Int) {
    
    var startRow: Int
    val occupied: IntArray
    val m: Int
    
    init {
        startRow = 0
        occupied = IntArray(n) { 0 }
        this.m = m
    }

    fun gather(k: Int, maxRow: Int): IntArray {
        for (row in startRow..maxRow) {
            if (occupied[row] <= this.m - k) {
                occupied[row] += k
                return intArrayOf(row, occupied[row] - k)
            }
        }
        
        return intArrayOf()
    }

    fun scatter(k: Int, maxRow: Int): Boolean {
        var rest = k
        
        var row = startRow
        while (row <= maxRow) {
            if (this.m - occupied[row] > rest) {
                break
            }
            rest -= this.m - occupied[row];
            row++
        }
        
        if (row >= maxRow + 1) {
            if (rest == 0) {
                startRow = row
                return true
            }
            return false
        }
        
        startRow = row
        occupied[row] += rest
        
        return true
    }
    
}

/**
 * Your BookMyShow object will be instantiated and called as such:
 * var obj = BookMyShow(n, m)
 * var param_1 = obj.gather(k,maxRow)
 * var param_2 = obj.scatter(k,maxRow)
 */
