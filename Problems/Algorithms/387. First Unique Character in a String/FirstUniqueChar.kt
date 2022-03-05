class Solution {
    fun firstUniqChar(s: String): Int {
        val map: MutableMap<Char, Pair<Int, Int>> = mutableMapOf()
        
        s.forEachIndexed { id, ch ->
            if (!map.containsKey(ch)) {
                map[ch] = Pair(id, 1)
            } else {
                map[ch] = Pair(id, 2)
            }
        }
        
        s.forEach {
            if (map.containsKey(it) && map[it]!!.second == 1) {
                return map[it]!!.first
            } 
        }
        
        return -1
    }
}

