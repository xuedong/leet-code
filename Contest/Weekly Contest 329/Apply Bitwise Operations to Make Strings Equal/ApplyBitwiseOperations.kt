class Solution {
    fun makeStringsEqual(s: String, target: String): Boolean {
        if (isZero(target) || isZero(s)) {
            return s == target
        }
        return true
    }
    
    private fun isZero(s: String): Boolean {
        val n = s.length
        for (i in 0..n-1) {
            if (s.get(i) != '0') return false
        }
        return true
    }
}
