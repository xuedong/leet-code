class Solution {
    fun findKDistantIndices(nums: IntArray, key: Int, k: Int): List<Int> {
        val set = mutableSetOf<Int>()
        
        for (i in 0..nums.size-1) {
            if (nums[i] == key) {
                for (j in maxOf(i-k, 0)..minOf(i+k, nums.size-1)) {
                    set.add(j)
                }
            }
        }
        
        return set.toList()
    }
}

