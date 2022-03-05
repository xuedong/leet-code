class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        return counter(s) == counter(t)
    }
    
    private fun counter(s: String): MutableMap<Char, Int> {
        val map: MutableMap<Char, Int> = mutableMapOf<Char, Int>()
        s.forEach { map.put(it, map.getOrDefault(it, 0) + 1) }
        return map
    }
}

