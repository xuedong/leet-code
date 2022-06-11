class Solution {
    fun matchReplacement(s: String, sub: String, mappings: Array<CharArray>): Boolean {
        val map: MutableMap<Char, MutableList<Char>> = mutableMapOf()
        for (mapping in mappings) {
            val old = mapping[0]
            val new = mapping[1]
            
            if (map.containsKey(old)) {
                map.get(old)!!.add(new)
            } else {
                map.put(old, mutableListOf(new))
            }
        }
        
        val n = sub.length
        val m = s.length
        for (i in 0..m-n) {
            var j = 0
            while (j < n) {
                if (sub.get(j) == s.get(i+j) || map.getOrDefault(sub.get(j), mutableListOf()).contains(s.get(i+j))) {
                    j++
                    continue
                }
                break
            }
            
            if (j == n) return true
        }
        
        return false
    }
}

