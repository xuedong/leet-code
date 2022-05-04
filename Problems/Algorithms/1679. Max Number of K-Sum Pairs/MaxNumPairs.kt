class Solution {
    fun maxOperations(nums: IntArray, k: Int): Int {
        val map: MutableMap<Int, Int> = mutableMapOf()
        
        var ans = 0
        for (num in nums) {
            if (map.containsKey(k-num) && map[k-num]!! > 0) {
                map.put(k-num, map.get(k-num)!! - 1)
                ans++
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1)
            }
        }
        
        return ans
    }
}

