class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        var ans = 0
        var prefix = 0
        val map = mutableMapOf<Int, Int>()
        
        map.put(0, 1)
        for (i in 0..nums.size-1) {
            prefix += nums[i]
            if (map.containsKey(prefix-k)) {
                ans += map.get(prefix-k)!!
            }
            map.put(prefix, map.getOrDefault(prefix, 0) + 1)
        }
        
        return ans
    }
}

