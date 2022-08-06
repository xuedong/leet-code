class Solution {
    fun countBadPairs(nums: IntArray): Long {
        val n = nums.size
        
        val diffs = IntArray(n)
        for (i in 0..n-1) {
            diffs[i] = nums[0] + i
            diffs[i] -= nums[i]
        }
        
        val map: MutableMap<Int, Int> = mutableMapOf()
        for (i in 0..n-1) {
            map.put(diffs[i], map.getOrDefault(diffs[i], 0) + 1)
        }
        
        var ans: Long = 0
        for (key in map.keys) {
            val value = map.get(key)!!
            ans += (value.toLong() - 1) * value.toLong() / 2
        }
        
        return n.toLong() * (n.toLong() - 1) / 2 - ans
    }
}

