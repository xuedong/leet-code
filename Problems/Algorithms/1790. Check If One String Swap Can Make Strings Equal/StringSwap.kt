class Solution {
    fun areAlmostEqual(s1: String, s2: String): Boolean {
        var count = 0
        var c1 = '.'
        var c2 = '.'
        for (i in 0..s1.length-1) {
            if (s1.get(i) != s2.get(i)) {
                if (count == 2) {
                    return false
                } else if (count == 0) {
                    c1 = s1.get(i)
                    c2 = s2.get(i)
                } else {
                    if (c1 != s2.get(i) || c2 != s1.get(i)) return false
                }
                count++
            }
        }
        
        if (count == 0 || count == 2) return true
        return false
    }
}

