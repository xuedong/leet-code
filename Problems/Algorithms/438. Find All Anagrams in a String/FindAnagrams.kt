/* The following solutions incurs TLE */
class Solution {
    fun findAnagrams(s: String, p: String): List<Int> {
        val map: MutableMap<String, MutableList<Int>> = mutableMapOf()
        
        val n = s.length
        val m = p.length
        if (n < m) return listOf()
        
        for (i in 0..n-m) {
            val curr = s.substring(i, i+m).toCharArray().sorted().joinToString("")
            if (!map.containsKey(curr)) {
                map.put(curr, mutableListOf(i))
            } else {
                map.get(curr)!!.add(i)
            }
        }
        
        return map.get(p.toCharArray().sorted().joinToString("")) ?: listOf()
    }
}

