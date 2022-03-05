class Solution {
    fun mostFrequent(nums: IntArray, key: Int): Int {
        val map: MutableMap<Int, Int> = mutableMapOf<Int, Int>()
        
        for (i in 1..nums.size-1) {
            if (nums[i-1] == key) {
                map.put(nums[i], map.getOrDefault(nums[i], 0)+1)
            }
        }

        var best = 0; var ans = nums[0]
        for ((key, value) in map) {
            if (value > best) {
                best = value
                ans = key
            }
        }
        
        return ans
    }
}

