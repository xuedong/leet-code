class Solution {
    fun mergeSimilarItems(items1: Array<IntArray>, items2: Array<IntArray>): List<List<Int>> {
        val map: MutableMap<Int, Int> = mutableMapOf()
        
        for (item in items1) {
            val value = item[0]
            val weight = item[1]
            
            map.put(value, map.getOrDefault(value, 0) + weight)
        }
        for (item in items2) {
            val value = item[0]
            val weight = item[1]
            
            map.put(value, map.getOrDefault(value, 0) + weight)
        }
        
        val results: MutableList<List<Int>> = mutableListOf()
        for (value in map.keys) {
            results.add(listOf(value, map.get(value)!!))
        }
        
        return results.sortedBy { it[0] }
    }
}

