class Solution {
    fun hasAllCodes(s: String, k: Int): Boolean {
        var total = (1 shl k)
        val hashes = IntArray(total) { 0 }
        
        var hash = 0
        for (i in 0..s.length-1) {
            hash = ((hash shl 1) and ((1 shl k) - 1) or (s.get(i) - '0'))
            
            if (i >= k - 1 && hashes[hash] == 0) {
                hashes[hash] = 1
                total--
            }
        }
        
        return total == 0
    }
}

