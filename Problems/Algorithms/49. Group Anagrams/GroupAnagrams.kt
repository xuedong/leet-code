class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val ans = mutableListOf<MutableList<String>>()
        val map = mutableMapOf<String, MutableList<String>>()
        
        for (string in strs) {
            val curr = string.toCharArray().sorted().joinToString()
            if (map.containsKey(curr)) {
                map[curr]!!.add(string)
            } else {
                map[curr] = mutableListOf<String>()
                map[curr]!!.add(string)
            }
        }
        
        for (key in map.keys) {
            ans.add(map[key]!!)
        }
        
        return ans
    }
}

