class Solution {
    fun sortJumbled(mapping: IntArray, nums: IntArray): IntArray {
        val newList = ArrayList<Pair<Int, Int>>()
        for (i in 0..nums.size-1) {
            val pair = Pair(transform(mapping, nums[i]), i)
            newList.add(pair)
        }
        val sortedList = newList.sortedWith(compareBy({ it.first }))
        
        val result = IntArray(nums.size) { it -> nums[sortedList.get(it).second] }
        return result
    }
    
    private fun transform(mapping: IntArray, num: Int): Int {
        var result = 0
        var multiply = 1
        var curr = num
        
        while (curr / 10 > 0) {
            val rest = curr % 10
            result += mapping[rest] * multiply
            multiply *= 10
            curr /= 10
        }
        result += mapping[curr] * multiply
        
        return result
    }
}
