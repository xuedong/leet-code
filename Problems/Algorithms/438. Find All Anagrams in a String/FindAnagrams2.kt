class Solution {
    fun findAnagrams(s: String, p: String): List<Int> {
        val map: MutableMap<Char, Int> = mutableMapOf()
        for (ch in p) {
            map.put(ch, map.getOrDefault(ch, 0) + 1)
        }
        
        val n = s.length
        val m = p.length
        if (n < m) return listOf()
        
        val results: MutableList<Int> = mutableListOf()
        for (i in 0..m-1) {
            if (map.containsKey(s.get(i))) {
                map.put(s.get(i), map.get(s.get(i))!!-1)
            }
        }
        if (map.all { it.value == 0 }) results.add(0)
        
        for (i in m..n-1) {
            if (map.containsKey(s.get(i))) {
                map.put(s.get(i), map.get(s.get(i))!!-1)
            }
            if (map.containsKey(s.get(i-m))) {
               map.put(s.get(i-m), map.get(s.get(i-m))!!+1)
            }
            
            if (map.all{ it.value == 0 }) results.add(i-m+1)
        }
        
        return results
    }
}

