class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        val len1 = s.length
        val len2 = t.length
        
        if (len1 > len2) return false
        if (len1 == 0) return true
        
        var i = 0
        var j = 0
        while (i < len1) {
            if (s.get(i) == t.get(j)) {
                i++
                j++
                if (i == len1) {
                    return true
                } else if (i < len1 && j == len2) {
                    return false
                }
            } else {
                j++
                if (j == len2) return false
            }
        }
        
        return false
    }
}

