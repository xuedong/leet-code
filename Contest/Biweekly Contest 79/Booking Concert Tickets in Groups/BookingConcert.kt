/* The following exceeds the memory limit */
class BookMyShow(n: Int, m: Int) {
    
    val seats: Array<IntArray>
    val occupied: IntArray
    val n: Int
    val m: Int
    
    init {
        seats = Array(n) { IntArray(m) { 0 } }
        occupied = IntArray(n) { 0 }
        this.n = n
        this.m = m
    }

    fun gather(k: Int, maxRow: Int): IntArray {
        if (k > this.m) return intArrayOf()
        
        for (r in 0..maxRow) {
            var sum = 0
            for (c in 0..k-1) {
                sum += seats[r][c]
            }
            
            var j = k
            while (sum > 0 && j < this.m) {
                sum -= seats[r][j-k]
                sum += seats[r][j]
                j++
            }
            
            if (sum == 0) {
                for (c in j-k..j-1) {
                    seats[r][c] = 1
                }
                occupied[r] += k
                return intArrayOf(r, j-k)
            }
        }
        
        return intArrayOf()
    }

    fun scatter(k: Int, maxRow: Int): Boolean {
        if (helper(k, maxRow)) {
            var rest = k
            for (r in 0..maxRow) {
                rest -= this.m - occupied[r]
                
                if (rest >= 0) {
                    for (c in 0..this.m-1) {
                        if (seats[r][c] == 0) seats[r][c] = 1
                    }
                    occupied[r] = this.m
                } else {
                    var j = 0
                    var count = 0
                    while (count < rest + this.m - occupied[r] && j < this.m) {
                        if (seats[r][j] == 0) {
                            seats[r][j] = 1
                            count++
                        }
                        j++
                    }
                    
                    occupied[r] = rest + this.m
                    break
                }
            }
            
            return true
        }
        
        return false
    }
    
    fun helper(k: Int, maxRow: Int): Boolean {
        var rest = k
        for (r in 0..maxRow) {
            rest -= this.m - occupied[r]
            if (rest <= 0) {
                return true
            }
        }
        
        return false
    }

}

/**
 * Your BookMyShow object will be instantiated and called as such:
 * var obj = BookMyShow(n, m)
 * var param_1 = obj.gather(k,maxRow)
 * var param_2 = obj.scatter(k,maxRow)
 */
