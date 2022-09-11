class Solution {
    fun mostFrequentEven(nums: IntArray): Int {
        val map: MutableMap<Int, Int> = mutableMapOf()

        for (num in nums) {
            if (num % 2 == 0) {
                map[num] = map.getOrDefault(num, 0) + 1
            }
        }

        var ans = -1
        var max = 0
        for (num in map.keys) {
            if (map.get(num)!! > max) {
                ans = num
                max = map.get(num)!!
            } else if (map.get(num)!! == max) {
                ans = Math.min(ans, num)
            }
        }

        return ans
    }
}
