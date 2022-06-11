/* The following solution leads to TLE */
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
        
        val queue = ArrayDeque<Pair<String, Int>>()
        queue.add(Pair(sub, -1))
        
        while (!queue.isEmpty()) {
            val curr = queue.removeFirst()
            val currSub = curr.first
            val currId = curr.second
            if (s.contains(currSub)) return true
            
            for (i in currId+1..n-1) {
                val oldChar = currSub.get(i)
                for (newChar in map.getOrDefault(oldChar, mutableListOf())) {
                    val newSub = currSub.substring(0, i) + newChar + currSub.substring(i+1)
                    queue.add(Pair(newSub, i))
                }
            }
        }
        
        return false
    }
}

