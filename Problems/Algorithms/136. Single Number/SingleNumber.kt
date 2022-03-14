class Solution {
    fun singleNumber(nums: IntArray): Int {
        val count = mutableMapOf<Int, Int>()
        
        for (num in nums) {
            count.put(num, count.getOrDefault(num, 0) + 1)
        }
        
        for (num in nums) {
            if (count[num] == 1) return num
        }
        
        return -1
    }
}

