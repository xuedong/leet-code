class Solution {
    fun maxEnvelopes(envelopes: Array<IntArray>): Int {
        envelopes.sortWith(compareBy({ it[0] }, { -it[1] }))
        
        val n = envelopes.size
        val pile = IntArray(n) { 0 }
        
        var size = 0
        for (envelope in envelopes) {
            val num = envelope[1]
            
            var left = 0
            var right = size
            
            while (left < right) {
                val mid = left + (right - left) / 2
                if (pile[mid] < num) {
                    left = mid + 1
                } else {
                    right = mid
                }
            }
            
            pile[right] = num
            if (left == size) size++
        }
        
        return size
    }
}

