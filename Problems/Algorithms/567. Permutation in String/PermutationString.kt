class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val n1 = s1.length
        val n2 = s2.length
        if (n1 > n2) return false
        
        val map1 = IntArray(26)
        val map2 = IntArray(26)
        
        for (i in 0..n1-1) {
            map1[s1.get(i)-'a']++
            map2[s2.get(i)-'a']++
        }
        
        for (i in 0..n2-n1-1) {
            if (match(map1, map2)) return true
            
            map2[s2.get(i+n1)-'a']++
            map2[s2.get(i)-'a']--
        }
        
        return match(map1, map2)
    }
    
    private fun match(map1: IntArray, map2: IntArray): Boolean {
        for (i in 0..25) {
            if (map1[i] != map2[i]) {
                return false
            }
        }
        
        return true
    }
}

