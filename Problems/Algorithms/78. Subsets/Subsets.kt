class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val results = mutableListOf(emptyList<Int>())
        
        nums.forEach { num ->
            val newSubsets = results.map { it + num }
            results.addAll(newSubsets)
        }
        
        return results
    }
}

