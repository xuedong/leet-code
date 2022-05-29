class Solution {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val counter1: Map<Int, Int> = buildCounter(nums1)
        val counter2: Map<Int, Int> = buildCounter(nums2)
        
        val ans: MutableList<Int> = mutableListOf()
        counter1.forEach { num, count ->
            val minCount: Int = minOf(count, counter2.getOrDefault(num, 0))
            repeat(minCount) {
                ans.add(num)
            }
        }
        
        return ans.toIntArray()
    }
    
    private fun buildCounter(nums: IntArray): Map<Int, Int> {
        val map: MutableMap<Int, Int> = mutableMapOf()
        
        nums.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        
        return map
    }
}

