class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val results = mutableListOf(emptyList<Int>())
        nums.sort()
        
        var prevSize = 0
        nums.forEachIndexed { idx, num ->
            val currSize = results.size
            if (idx != 0 && nums[idx-1] == nums[idx]) {
                for (j in currSize-1 downTo currSize-prevSize) {
                    val newSubset = results.get(j)
                    results.add(newSubset + num)
                }
            } else {
                val newSubsets = results.map { it + num }
                results.addAll(newSubsets)
                prevSize = currSize
            }
        }
        
        return results
    }
}

