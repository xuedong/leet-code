class Solution {
    fun maximumUniqueSubarray(nums: IntArray): Int {
        val map: MutableMap<Int, Int> = mutableMapOf()
        val n = nums.size
        
        var ans = 0
        var sum = 0
        var j = 0
        for (i in 0..n-1) {
            val curr = nums[i]
            if (!map.containsKey(curr) || map.get(curr)!! == 0) {
                map.put(curr, 1)
                sum += curr
            } else {
                ans = maxOf(ans, sum)
                while (nums[j] != curr) {
                    map.put(nums[j], map.get(nums[j])!! - 1)
                    sum -= nums[j]
                    j++
                }
                j++
            }
        }
        ans = maxOf(ans, sum)
        
        return ans
    }
}

